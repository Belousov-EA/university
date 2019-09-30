
class FigureColor:
    def __init__(self):
        self._color = [0, 0, 0]

    def setcolor(self, rgb_color):
        if(len(rgb_color) == 3)\
            and rgb_color[0] >= 0 and rgb_color[0] <= 255\
            and rgb_color[1] >= 0 and rgb_color[1] <= 255 \
            and rgb_color[2] >= 0 and rgb_color[2] <= 255:
                        self._color = rgb_color
        else:
            raise ValueError

    def getcolor(self):
        return self._color

    def delcolor(self):
        self._color = [0, 0, 0]

    color = property(getcolor, setcolor, delcolor, 'rgb color')
