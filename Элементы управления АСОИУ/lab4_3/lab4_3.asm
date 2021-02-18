.include "m16def.inc" ; подключение библиотеки для работы с ATmega16
.list ; включение листинга
.def temp=r16 ; определение главного рабочего регистра
.def k_end=r17
.def k___=r18
.def s___=r19
;--------------------------------------------
.cseg ; выбор сегмента программного кода
.org 0 ; установка текущего адреса на ноль
;--------------------------------------------
ldi temp,0x80 ; выключение компаратора
out acsr,temp
;--------------------------------------------
ldi temp,0x00	; 0 --> temp
out ddrd,temp	; Назначаем порт rd на ввод (00000000 --> ddrd)
ldi temp,0xFF	; 0xff --> temp
out ddrb,temp	; Назначаем порт rb на вывод (11111111 --> ddrb)
;---------------------------------------------
ldi temp, 0b101	; Предделение 1024
out tccr0, temp
ldi temp, 135	; Коррекция тактовой частоты
out osccal, temp

ldi	temp,low(RAMEND)	; инициализация стека
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
subr_delay:     ; "1" длится k__z тактов с предделением в конце 0
ldi	s___, 1		; 1 --> s___
out	portb, s___ ; s___ --> pb
out	tcnt0, temp	; 0 --> tcnt0 Обнуление таймера
ccc1:			; повтор цикла
in	k___, tcnt0	; считали таймер
cp	k___, k_end	; сравнили k__ и k__z
brlo	ccc1	; если k___<k__z, ушли в начало
ldi	s___, 0		; 0 --> s___
out	portb, s___ ; s___ --> pb
ret			    ; конец подпрограммы subr_delay
