#include "thermo.h"
#include <stdio.h>
#include <math.h>
// Uses the two global variables (ports) THERMO_SENSOR_PORT and
// THERMO_STATUS_PORT to set the temp structure. If THERMO_SENSOR_PORT
// is above its maximum trusted value, associated with +50.0 deg C,
// does not alter temp and returns 1.  Otherwise, sets fields of temp
// based on converting sensor value to degrees and checking whether
// Celsius or Fahrenheit display is in effect. Returns 0 on successful
// set. This function DOES NOT modify any global variables but may
// access global variables.
//
// CONSTRAINT: Uses only integer operations. No floating point
// operations are used as the target machine does not have a FPU.
int set_temp_from_ports(temp_t *temp)
{
    if(THERMO_SENSOR_PORT > 64000) // if sensor is over that ammount its too high so return 1
    {
        return 1; //returns 1 for invalid input
    }
    if((THERMO_STATUS_PORT) & (1 << 0)) //checks that last bit a is a 1
    {
        temp -> is_fahrenheit = 1; //sets to 1 so it knows its in far
        if((THERMO_SENSOR_PORT % 64) >=32) // using mod 32 to round it up if its halfway to next 0.1
        {
            temp -> tenths_degrees = (1.8*((-500) + (THERMO_SENSOR_PORT / 64) + 1)) + 320; // equation for fahrenheit plus one for rounding up
        }
        else
        {
            temp -> tenths_degrees = (1.8*((-500) + (THERMO_SENSOR_PORT / 64))) + 320; // equation for far without rounding up
        }
        
    }
    else
    {
        temp -> is_fahrenheit = 0; //sets to 0 so it knows its in cel
        if((THERMO_SENSOR_PORT % 64) >=32) // checks if it should round or not
        {
            temp -> tenths_degrees = ((-500) + (THERMO_SENSOR_PORT / 64) + 1); // equation for cel plus one for rounding up
        }
        else
        {
            temp -> tenths_degrees = ((-500) + (THERMO_SENSOR_PORT / 64)); // reuation for cel without rounding up
        }  
    }
    
    return 0; //returns 0 for nothing wrong
}

// Alters the bits of integer pointed to by display to reflect the
// temperature in struct arg temp.  If temp has a temperature value
// that is below minimum or above maximum temperature allowable or if
// an improper indication of celsius/fahrenheit is given, does nothing
// and returns 1. Otherwise, calculates each digit of the temperature
// and changes bits at display to show the temperature according to
// the pattern for each digit.  This function DOES NOT modify any
// global variables but may access global variables.
int set_display_from_temp(temp_t temp, int *display)
{
    if(temp.is_fahrenheit == 1) // if far
    {
        if(temp.tenths_degrees < -580 || temp.tenths_degrees > 1220) // if below min or above max return 1 for error
        {
            return 1;
        }
    }
    else if (temp.is_fahrenheit == 0) // if cel
    {
        if(temp.tenths_degrees <-500 || temp.tenths_degrees > 500) // if below min or above max return 1 for error
        {
            return 1;
        }
    }
    else // any other input is bad so return 1 for error
    {
        return 1;
    }
    
    
    int x = 0;
    *display = x; // says to do this in instructions

    int bitHolder[10]; // holds bit masks for each number
    bitHolder[0] = 0b1111110;
    bitHolder[1] = 0b0001100;
    bitHolder[2] = 0b0110111;
    bitHolder[3] = 0b0011111;
    bitHolder[4] = 0b1001101;
    bitHolder[5] = 0b1011011;
    bitHolder[6] = 0b1111011;
    bitHolder[7] = 0b0001110;
    bitHolder[8] = 0b1111111;
    bitHolder[9] = 0b1011111;

    int holder = temp.tenths_degrees;
    int temp_hundreds;
    temp_hundreds = -2; // could be anything, we check later if its -1, otherwise it looks for a num
    if(holder < 0) // if num is negative make hundreds place a - sign and make rest of numbers positive
    {
        temp_hundreds = -1;
        holder *= -1;
    }

    int y = 0; // y is set to the display later on
    if(holder < 10) // if number is only tenths placec
    {
        int temp_tenths =  holder % 10; // stores last number off end
        holder /= 10; // removes last number off end
        int mask_tenths = bitHolder[temp_tenths]; //takes mask for that num 
        y |= mask_tenths; // |= adds bitmask to the display temp
        int mask_zero = bitHolder[0]; // adds a 0 beccause only tenths place is given
        mask_zero = mask_zero << 7; // moves over 7 for next num
        y |= mask_zero; // adds zero
        if(temp_hundreds == -1) // adds the negative if needed
        {
            int mask_hundreds = 0b0000001;
            mask_hundreds = mask_hundreds << 14;
            y|= mask_hundreds;
        }
        else
        {
            int mask_hundreds = 0b0000000;
            mask_hundreds = mask_hundreds << 14;
            y|= mask_hundreds;
        }
        int mask_temp = 0b0000000; // adding in blank spaccce because nothing is here
        mask_temp = mask_temp << 21;
        y|= mask_temp;
        if(temp.is_fahrenheit == 1) // if far set 29th bit to 1
        {
            int f_mask = 1 << 29;
            y |= f_mask; 
        }
        else // if ccel set 28th bit to 1
        {
            int c_mask = 1 << 28;
            y |= c_mask;
        }
    }
    else if(holder < 100) // if number is only ones and tenths place
    {
        int temp_tenths =  holder % 10; //everything uses same reasoning as above
        holder /= 10; 
        int temp_ones = holder % 10; 
        holder /= 10;

        int mask_tenths = bitHolder[temp_tenths]; 
        y |= mask_tenths;
        int mask_ones = bitHolder[temp_ones];
        mask_ones = mask_ones << 7;
        y|= mask_ones;

        if(temp_hundreds == -1)
        {
            int mask_hundreds = 0b0000001;
            mask_hundreds = mask_hundreds << 14;
            y|= mask_hundreds;
        }
        else
        {
            int mask_hundreds = 0b0000000;
            mask_hundreds = mask_hundreds << 14;
            y|= mask_hundreds;
        }
        int mask_temp = 0b0000000;
        mask_temp = mask_temp << 21;
        y|= mask_temp;
        if(temp.is_fahrenheit == 1)
        {
            int f_mask = 1 << 29;
            y |= f_mask; 
        }
        else
        {
            int c_mask = 1 << 28;
            y |= c_mask;
        }
    }
    else // everything else, has hundreds place as negative or the final num
    {
        int temp_tenths =  holder % 10; // everything uses same reasoning as above just adding a couple more nums
        holder /= 10;
        int temp_ones = holder % 10;
        holder /= 10;
        int temp_tens = holder % 10;
        holder /= 10;
        
        

        int mask_tenths = bitHolder[temp_tenths];
        y |= mask_tenths;
        int mask_ones = bitHolder[temp_ones];
        mask_ones = mask_ones << 7;
        y|= mask_ones;
        int mask_tens = bitHolder[temp_tens];
        mask_tens = mask_tens << 14;
        y|= mask_tens;
        if(temp_hundreds == -1)
        {
            int mask_hundreds = 0b0000001;
            mask_hundreds = mask_hundreds << 21;
            y|= mask_hundreds;
        }
        else
        {
            int temp_hundredHelp = holder % 10;
            if(temp_hundredHelp > 0)
            {
                int mask_hundreds = bitHolder[temp_hundredHelp];
                mask_hundreds = mask_hundreds << 21;
                y|= mask_hundreds;
            }
            else
            {
                int mask_hundreds = 0b0000000;
                mask_hundreds = mask_hundreds << 21;
                y|= mask_hundreds;
            }   
        }
        if(temp.is_fahrenheit == 1)
        {
            int f_mask = 1 << 29;
            y |= f_mask; 
        }
        else
        {
            int c_mask = 1 << 28;
            y |= c_mask;
        }
    }
    
    *display = y;
    return 0;
}

// Called to update the thermometer display.  Makes use of
// set_temp_from_ports() and set_display_from_temp() to access
// temperature sensor then set the display. Checks these functions and
// if they indicate an error, makes not changes to the display.
// Otherwise modifies THERMO_DISPLAY_PORT to set the display.
// 
// CONSTRAINT: Does not allocate any heap memory as malloc() is NOT
// available on the target microcontroller.  Uses stack and global
// memory only.
int thermo_update()
{
    temp_t x = { .is_fahrenheit='0', .tenths_degrees = 0} ; // sets up a temp_t struct with 0's. Doesnt matter because these get set in set temp from ports
    set_temp_from_ports(&x); // sets up temp_t with correcct values
    return set_display_from_temp(x,&THERMO_DISPLAY_PORT); // sets the display to current temp from set_temp_from_ports
}