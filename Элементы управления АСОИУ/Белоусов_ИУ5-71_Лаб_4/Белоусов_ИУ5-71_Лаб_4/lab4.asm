.include "m16def.inc" ; ����������� ���������� ��� ������ � ATmega16
.list ; ��������� ��������
.def temp=r16 ; ����������� �������� �������� ��������
.def k_end=r17
.def k___=r18
.def s___=r19
;--------------------------------------------
.cseg ; ����� �������� ������������ ����
.org 0 ; ��������� �������� ������ �� ����
;--------------------------------------------
ldi temp,0x80 ; ���������� �����������
out acsr,temp
;--------------------------------------------
ldi temp,0x00	; 0 --> temp
out ddrd,temp	; ��������� ���� rd �� ���� (00000000 --> ddrd)
ldi temp,0xFF	; 0xff --> temp
out ddrb,temp	; ��������� ���� rb �� ����� (11111111 --> ddrb)
;---------------------------------------------
ldi temp, 0b101	; ����������� 1024
out tccr0, temp
ldi temp, 135	; ��������� �������� �������
out osccal, temp

ldi	temp,low(RAMEND)	; ������������� �����
out	spl,temp
ldi	temp,high(RAMEND)
out	sph,temp

ldi	temp, 0


;-------------------------------------------------
met:

ldi	k_end, 10
rcall	subr_delay

rcall	subr_delay

ldi k_end, 1
rcall	subr_delay

ldi	k_end, 10
rcall	subr_delay

rcall	subr_delay

rcall	subr_delay

ldi	k_end, 5
rcall	subr_delay

ldi	k_end, 10
rcall	subr_delay

rcall	subr_delay

ldi	k_end, 50
rcall	subr_delay

jmp	met


;-------------------------------------------------------
subr_delay:     ; "1" ������ k__z ������ � ������������ � ����� 0
ldi	s___, 1		; 1 --> s___
out	portb, s___ ; s___ --> pb
out	tcnt0, temp	; 0 --> tcnt0 ��������� �������
ccc1:			; ������ �����
in	k___, tcnt0	; ������� ������
cp	k___, k_end	; �������� k__ � k__z
brlo	ccc1	; ���� k___<k__z, ���� � ������
ldi	s___, 0		; 0 --> s___
out	portb, s___ ; s___ --> pb
ret			    ; ����� ������������ subr_delay
