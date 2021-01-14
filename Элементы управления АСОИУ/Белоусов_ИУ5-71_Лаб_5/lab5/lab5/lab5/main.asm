;
; lab5.asm
;
; Created: 07.12.2020 15:33:53
; Author : Ilya
;

.include "m16def.inc" ; ����������� ���������� ��� ������ � ATmega16
.list ; ��������� ��������
.def temp=r16 ; ����������� �������� �������� ��������
.def comp=r17
.def t___=r18
;--------------------------------------------
.cseg ; ����� �������� ������������ ����
.org 0 ; ��������� �������� ������ �� ����
;--------------------------------------------
ldi temp,0x80	; ���������� �����������
out acsr,temp
;--------------------------------------------
ldi temp,0x00	; 0 --> temp
out ddra,temp	; ��������� ���� ra �� ���� (00000000 --> ddra)
ldi temp,0x01	; 0xff --> temp
out ddrb,temp	; ��������� ���� rb(1) �� ����� (00000001 --> ddrb)
ldi temp,0xFF	; 0xff --> temp
out ddrd,temp	; ��������� ���� rd �� ����� (11111111 --> ddrd)
;---------------------------------------------
ldi temp, 0b10	; ����������� 8
out tccr0, temp
ldi temp, 125	; ��������� �������� �������
out osccal, temp
ldi temp, 0			; 0 --> temp
out tcnt0, temp		; temp --> tcnt0 ��������� �������

loop:				
ldi temp, 1			;capacitor discharge impulse
out portb, temp		; 1 --> pb
ldi temp, 0			; 0 --> temp
out tcnt0, temp		; temp --> tcnt0 ��������� �������
out portb, temp		; 0 --> pb
ccc1:				; ������ �����
in comp, pina		; ������� �����������
cpi comp, 0x01		; �������� comp � 1
brlo ccc1			; ���� comp < 1, ���� � ������
in t___, tcnt0		; read timer
lsr t___			;devide timer by 2
lsr t___			;devide timer by 2
out portd, t___		;voltage output
jmp loop
