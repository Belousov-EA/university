$(function() {
    // ждем загрузки страницы
})

var $from = $('.from');
var $to = $('.to');
var $button = $('.but');
var $output = $('.output');
var $fun = $('.fun')
$button.click(onClick);

function magic(value)
{
    var x = value;
    var fun = $fun.val();
    y = eval(fun);
    return y;
}

function onClick()
{
    var from = parseFloat($from.val());
    var to = parseFloat($to.val());
    if (isNaN(from) || isNaN(to) )
    {
        alert("Введите значения");
        return;
    }
    var n = 1000;
    var delta = (to - from)/n;
    var points = [];
    for(var i = 0; i < n; i++)
    {
        x = from + (delta * i);
        y = magic(x);
        points.push([x, y]);
    }
    $.plot($output, [ points ], {});
}




