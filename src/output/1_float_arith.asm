
	.text


	.globl main

main:

L1:	la	 $a0, CONST1		 #Load an immediate value to register
	l.s	 $f2, 0($a0)		 #Load the value at the address
	s.s	 $f2, f1

L3:	la	 $a0, CONST2		 #Load an immediate value to register
	l.s	 $f2, 0($a0)		 #Load the value at the address
	s.s	 $f2, f2

L4:	la	 $a0, CONST3		 #Load an immediate value to register
	l.s	 $f2, 0($a0)		 #Load the value at the address
	s.s	 $f2, f3

L5:	l.s	 $f2, f1
	l.s	 $f3, f2
	add.s	 $f4, $f2, $f3		#add the two registers

	l.s	 $f5, f3
	add.s	 $f6, $f4, $f5		#add the two registers

	s.s	 $f6, sum

L6:	li	 $v0,4		#Load the system call to print a string
	la	 $a0, msg1		#Load the String to be printed
	syscall

	li	 $v0, 2		#Load system call to print float
	l.s	 $f12, f1		#Load the float from f12 to f1
	syscall


L7:	li	 $v0,4		#Load the system call to print a string
	la	 $a0, msg2		#Load the String to be printed
	syscall

	li	 $v0, 2		#Load system call to print float
	l.s	 $f12, f2		#Load the float from f12 to f2
	syscall


L8:	li	 $v0,4		#Load the system call to print a string
	la	 $a0, msg3		#Load the String to be printed
	syscall

	li	 $v0, 2		#Load system call to print float
	l.s	 $f12, f3		#Load the float from f12 to f3
	syscall


L9:	li	 $v0,4		#Load the system call to print a string
	la	 $a0, msg4		#Load the String to be printed
	syscall

	li	 $v0, 2		#Load system call to print float
	l.s	 $f12, sum		#Load the float from f12 to sum
	syscall


L10:	l.s	 $f2, f2
	l.s	 $f3, f1
	sub.s	 $f4, $f2, $f3		#add the two registers

	s.s	 $f4, difference

L11:	li	 $v0,4		#Load the system call to print a string
	la	 $a0, msg5		#Load the String to be printed
	syscall

	li	 $v0, 2		#Load system call to print float
	l.s	 $f12, difference		#Load the float from f12 to difference
	syscall


L12:	la	 $a0, CONST4		 #Load an immediate value to register
	l.s	 $f2, 0($a0)		 #Load the value at the address
	s.s	 $f2, v1

L13:	li	 $v0,4		#Load the system call to print a string
	la	 $a0, msg6		#Load the String to be printed
	syscall

	li	 $v0, 2		#Load system call to print float
	l.s	 $f12, v1		#Load the float from f12 to v1
	syscall


L14:	l.s	 $f2, v1
	l.s	 $f3, v1
	mul.s	 $f4, $f3, $f3		#add the two registers

	l.s	 $f5, v1
	mul.s	 $f6, $f4, $f5		#add the two registers

	s.s	 $f6, v1

L15:	li	 $v0,4		#Load the system call to print a string
	la	 $a0, msg7		#Load the String to be printed
	syscall

	li	 $v0, 2		#Load system call to print float
	l.s	 $f12, v1		#Load the float from f12 to v1
	syscall


L16:	l.s	 $f2, v1
	la	 $a0, CONST5		 #Load an immediate value to register
	l.s	 $f3, 0($a0)		 #Load the value at the address
	div.s	 $f4, $f2, $f3		#add the two registers

	s.s	 $f4, v2

L17:	li	 $v0,4		#Load the system call to print a string
	la	 $a0, msg8		#Load the String to be printed
	syscall

	li	 $v0, 2		#Load system call to print float
	l.s	 $f12, v2		#Load the float from f12 to v2
	syscall


L2:	li $v0, 10		#Load system call to exit
	syscall


	.data

v2:	.float	0,0,0
v1:	.float	0,0,0
difference:	.float	0,0,0
sum:	.float	0,0,0
f3:	.float	0,0,0
f2:	.float	0,0,0
f1:	.float	0,0,0
CONST1:	.float	12.000000
CONST2:	.float	33.400002
CONST3:	.float	10.000000
CONST4:	.float	5.000000
CONST5:	.float	5.000000
BOOL_TRUE:	.byte	1
BOOL_FALSE:	.byte	0
BOOL_TRUE_STR:	.asciiz	"true"
BOOL_FALSE_STR:	.asciiz	"false"
msg1:	.asciiz "f1 is "
msg2:	.asciiz "\nf2 is "
msg3:	.asciiz "\nf3 is "
msg4:	.asciiz "\nsum = f1 + f2 + f3 = "
msg5:	.asciiz "\ndifference is f2 - f1 = "
msg6:	.asciiz "\nv1 = "
msg7:	.asciiz "\nv1 = v1*v1*v1 = "
msg8:	.asciiz "\nv2 = v1 / 5 = "
