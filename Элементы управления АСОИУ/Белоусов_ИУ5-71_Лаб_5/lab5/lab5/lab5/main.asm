;
; lab5.asm
;
; Created: 07.12.2020 15:33:53
; Author : Ilya
;

.include "m16def.inc" ; подключение библиотеки для работы с ATmega16
.list ; включение листинга
.def temp=r16 ; определение главного рабочего регистра
.def comp=r17
.def t___=r18
;--------------------------------------------
.cseg ; выбор сегмента программного кода
.org 0 ; установка текущего адреса на ноль
;--------------------------------------------
ldi temp,0x80	; выключение компаратора
out acsr,temp
;--------------------------------------------
ldi temp,0x00	; 0 --> temp
out ddra,temp	; Назначаем порт ra на ввод (00000000 --> ddra)
ldi temp,0x01	; 0xff --> temp
out ddrb,temp	; Назначаем порт rb(1) на вывод (00000001 --> ddrb)
ldi temp,0xFF	; 0xff --> temp
out ddrd,temp	; Назначаем порт rd на вывод (11111111 --> ddrd)
;---------------------------------------------
ldi temp, 0b10	; Предделение 8
out tccr0, temp
ldi temp, 125	; Коррекция тактовой частоты
out osccal, temp
ldi temp, 0			; 0 --> temp
out tcnt0, temp		; temp --> tcnt0 Обнуление таймера

loop:				
ldi temp, 1			;capacitor discharge impulse
out portb, temp		; 1 --> pb
ldi temp, 0			; 0 --> temp
out tcnt0, temp		; temp --> tcnt0 Обнуление таймера
out portb, temp		; 0 --> pb
ccc1:				; повтор цикла
in comp, pina		; считали компарартор
cpi comp, 0x01		; сравнили comp и 1
brlo ccc1			; если comp < 1, ушли в начало
in t___, tcnt0		; read timer
lsr t___			;devide timer by 2
lsr t___			;devide timer by 2
out portd, t___		;voltage output
jmp loop
