### Begin with functions/executable code in the assmebly file via '.text' directive
.text
.global  set_temp_from_ports
        
## ENTRY POINT FOR REQUIRED FUNCTION
set_temp_from_ports:
        ## assembly instructions here
        movw    THERMO_SENSOR_PORT(%rip), %dx   #move global cvar thermo_sensor_port into edx
        cmpw    $64000, %dx                     #compares 64000 to thermo_sensor_port
        ja      .ERROR                          #if greater than go to error
        movw    %dx, %ax                        #move thermo_sensor_port value into eax

        andw    $0b111111, %dx                  #andw the first 6 bits to get remainder
        shrw    $6,%ax                          #shifts thermo_sensor port value over by 6 to divide by 64
        movq    $0, %rsi
        movw    %ax, %si                        # moving quotient into esi so i can do math on it
        subw    $500,%si                        #subtracting 500 from thermo_sensor/64 to get celcius
        cmpw    $32,%dx                         #comparing 32 to remainder to see if i need to round up or not
        jae     .ROUND
.AFTERROUND:                          
        movl    THERMO_STATUS_PORT(%rip), %edx  #move global var status into edx
        movl    $1, %eax                        #put 1 into eax
        sall    $0, %eax                        #bitwise it so its all 0 and a single 1 at end
        andl    %eax, %edx                      #and eax and edx to make sure its either a 1 or 0 at end and nothing else
        cmpl    $0, %edx                        #check if edx has a 1 or 0
        ja      .FAHRENHEIT                     # if set to 1 it is fahrenheit, use ja?
        jmp     .CELCIUS                        #jump to celcius if not fahrenheit
.AFTERSENSOR:
        movw    %si,(%rdi)                      #put cel or far temp into struct
        movq    $0, %rax                        #move 0 into rax to return it
        ret
        
.CELCIUS:
        movb    $0,2(%rdi)                      #add line for setting struct value to 0
        jmp     .AFTERSENSOR                    #jump to aftersensor 
.FAHRENHEIT:
        imulw   $9, %si                         #multiply celcius by 9
        movw    %si, %ax                        #put celcius * 9 into eax so i can divide
        cwtl                                    #Wut
        cltq                                    #division magic
        cqto                                    #whatever this does
        movl    $5, %ecx                        # put 5 into edx so i can divide by 5
        idivl   %ecx                            # dividing celcius*9 by 5 to get far
        movw    %ax, %si                        #moving quotient back into esi for ease
        addw    $320, %si                       #add 320 to our current value
        movb    $1,2(%rdi)                      #add line for setting struct thing to 1
        jmp     .AFTERSENSOR                    #jump to after sensor
.ROUND:
        addw    $1,%si                          #rounds esi up by one if remainder is 32 or above
        jmp     .AFTERROUND                     #jump to after round
.ERROR:                                         #happens if sensor port is an invalidly high input
        movl    $1,%eax                         #moves 1 into rax so it can be returned
        ret
### Change to definint semi-global variables used with the next function 
### via the '.data' directive

.data

BLANK:                         # declare location an single integer named 'my_int'
        .int 0b0000000               # value 1234

NEGATIVE:                      # declare another int accessible via name 'other_int'
        .int 0b0000001             # binary value as per C

mask_arr:                       # declare multiple ints sequentially starting at location
        .int 0b1111110                 # 'my_array' for an array. Each are spaced 4 bytes from the
        .int 0b0001100            # next and can be given values using the same prefixes as 
        .int 0b0110111            # are understood by gcc.
        .int 0b0011111
        .int 0b1001101
        .int 0b1011011
        .int 0b1111011
        .int 0b0001110
        .int 0b1111111
        .int 0b1011111

### Change back to defining functions/execurable instructions
.text
.global  set_display_from_temp

// ## ENTRY POINT FOR REQUIRED FUNCTION
set_display_from_temp:
        movl %edi, %r8d         #move temp_t struct into r8d
        sarl $16,%r8d           #shift left by 16 to get fah/cel sensor value
        cmpb $0,%r8b            #compare f/c sensor value to 0
        je .CELERRORCHECK       #if equal to 0 go to celerrorcheck
        cmpb $1,%r8b            #compare f/c sensor value to 1
        je .FAHERRORCHECK       #if equal to 1 go to faherrorcheck
        jmp .ERROR3              #if f/c sensor is not equal to 1 or 0 go to error

.CELERRORCHECK:
        cmpw $-500, %di        #check if temp is less than min cel value
        jl .ERROR3               #if less than -500 jmp to error
        cmpw $500, %di         #check if temp is greater than max cel value
        jg .ERROR3               #if greater than 500 jump to error
        jmp .AfterErrorCheck     #if passed all checks then go to aftererrorcheck

.FAHERRORCHECK:
        cmpw $-580, %di        #check if temp is less than min fah value
        jl .ERROR3               #if less than -580 go to error
        cmpw $1220, %di        #check if temp is greater than max fah value
        jg .ERROR3               #if greater than 1220 jump to error
        jmp .AfterErrorCheck     #if passed all the checks then go to after error check

.AfterErrorCheck:
        movl $0, %r9d            #move 0 into r9(disp from c code)
        movl %edi,%r10d          #move temp.tenths_degrees into r10(quo from c)
        cmpw $0,%r10w            #compare tenths_degrees to 0
        jl .NEGWORK             #if less than negative jump to neg work

.AfterNegWork:
        movw %r10w, %ax                        
        movl $10, %ecx                          #move 10 into rcx for division
        cwtl                                    #Wut
        cltq                                    #division stuff?
        cqto                                    #prep for division
        idivl   %ecx                            #divide by 10
        movl %edx, %r11d                       #move remainder into r11(tenths)
        cqto                                    #prep for division
        idivl   %ecx                            #divide by 10
        movl %edx, %r12d                        #move remainder into r12(ones)
        cqto                                    #prep for division
        idivl   %ecx                            #divide by 10
        movl %edx, %r13d                        #move remainder into r13(tens)
        cqto                                    #prep for division
        idivl   %ecx                            #divide by 10
        movl %edx, %r14d                        #move remainder into r14(hundreds)
        leaq mask_arr(%rip),%rcx                #load the mask arr into rcx
        cmpl $0, %r14d                          #compare hundreds to 0 to see if we need to put a val into disp
        jne .AddHundred                          #adds the number to disp if not 0
.AfterHundred:
        cmpl $0, %r13d                          #compare tens to 0 to see if we need to add to disp
        jne .AddTen                              #if not 0 add number to disp

.AfterTen:
        orl (%rcx,%r12,4), %r9d                 #get the mask from the mask arr for the tens and or it on
        sall $7, %r9d                           #shift left by 7
        orl (%rcx,%r11,4), %r9d                 #get the mask from mask arr for the ones place and or it on
        cmpb    $0,%r8b                         #compare 0 to fah/cel sensor
        je .IsCel                               #if 0 then go to IsCel
        jne .IsFah                              #if not 0 then it is 1 then go to IsFah
.AfterFahCel:
        movl %r9d, (%rsi)                       #move display reg into display(arg 2)
        movl $0, %eax                           # move 0 into eax to return it
        ret                                     #End of func


.IsCel:
        movl $0b1, %ebx                         #move 1 into ebx
        sall $28, %ebx                          #shift to the left 28
        orl %ebx, %r9d                          #or it onto display reg, 28 sets cel light on
        jmp .AfterFahCel                        #jump to after fah cel
.IsFah:
        movl $0b1, %ebx                         #move 1 into ebx
        sall $29, %ebx                          #shift to the left 29
        orl %ebx, %r9d                          #or it into display reg, 29 sets fah light
        jmp .AfterFahCel                        #jump to after fah cel
.AddTen:
        orl (%rcx,%r13,4), %r9d         #bitwise or the mask onto disp
        sall $7, %r9d                           #shift over 7
        jmp .AfterTen                            #jump to after ten
.AddHundred:
        orl (%rcx,%r14,4), %r9d         #bitwise or the mask onto disp
        sall $7, %r9d                           #shift over 7 
        jmp .AfterHundred                        #jump to after hundred

.NEGWORK:
        orl $0b0000001, %r9d       #or the negative mask onto r9
        sall $7, %r9d            #shift it over 7
        negw %r10w               #negate tenths degrees to make all remaining nums positive
        jmp .AfterNegWork               #jump afternegwork
.ERROR3:
        movq $1,%rax            #put 1 into rax to return
        ret                     #end of funcc


	// ## two useful techniques for this problem
        // movl    my_int(%rip),%eax    # load my_int into register eax
        // leaq    my_array(%rip),%edx  # load pointer to beginning of my_array into edx


.text
.global thermo_update
        
## ENTRY POINT FOR REQUIRED FUNCTION
thermo_update:
	## assembly instructions here
        pushq   $0                                      #makes a stack with 0
        movq    %rsp, %rdi                              #moves what stack pointer is poinitng to into rdi(arg1)
        call    set_temp_from_ports                     #calls set temp from ports
        cmpq    $0, %rax                                #checks return value isnt 0 which would mean an error happened
        jne     .ERROR2                                 #jumps to error if value isnt 0
        movq    (%rsp), %rdi                            #moves what stacck pointer is pointing tos mem adress into rdi(first arg)
        movq    %rsp, %rsi                              #moves what stack pointer is pointing to into rsi
        call    set_display_from_temp                   #call set display from temp
        cmpq    $0, %rax                                #makes sure return value isnt 0
        jne     .ERROR2                                 #if not equal to 0 go to error call
        popq    %r10                                    #pop off stack into r10
        movl    %r10d, THERMO_DISPLAY_PORT(%rip)        #move r10 into global var thermo_display_port
        movq    $0, %rax                                #move 0 into rax to return it
        ret

.ERROR2:
        popq    %rdi                                    #pop element off queue and put into rdi
        movq    $1, %rax                                #move 1 into rax to return
        ret