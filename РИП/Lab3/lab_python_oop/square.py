from lab_python_oop.rectangle import Rectangle

class Square(Rectangle):
    def __init__(self, weight, color):
        super().__init__(weight, weight, color)
        self.name = 'Квадрат'

    def __repr__(self):
        return 'Квадрат со стороной {0},' \
               'площадью {1}, цвета {2}'.format(self.weight,
                                                self.calc_square(),
                                                self.figure_color.color)


    def get_name(self):
        return self.name
