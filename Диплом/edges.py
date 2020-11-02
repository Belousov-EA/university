import math

#метавершина Пуля
def e1(mass, energy):
    return math.sqrt( 2 * energy / mass )
    
def e2(speed, energy):
    return 2 * energy / ( speed ** 2 )
    
def e3(speed, mass):
    return mass * ( speed ** 2 ) / 2
    

class Bullet:
    def __init__( self, mass, energy, speed );
        self.mass=mass
        self.energy=energy
        self.speed=speed
    
    def reverse_constructor( self, mass, energy, speed ):
        if( mass == NULL ):
            mass = self.mass
        if( energy == NULL ):
            energy = self.energy
        if( speed == NULL ):
            speed = self.speed



def e4 (depth, resistance_force):
    return depth * resistance_force
    
def e5(energy, resistance_force):
    return energe / resistance_force

def e6(energy, depth):
    return energy / depth
    

class Wall:
    def __init__( self, depth, energy, resistance_force):
        self.depth = depth
        self.resistance_force=resistance_force
        self.energy=energy
        
    def reverse_constructor( self, depth, energy, resistance_force):
        if( depth == NULL ):
            depth = self.depth
        if( energy == NULL ):
            energy == self.energy
        if( resistance_force == NULL ):
            resistance_force = self.resistance_force
    
    
def to_slow_down(bullet, wall, end_speed):
    wall.energy = bullet.energy - bullet.mass * (end_speed ** 2) / 2
    
    
def to_penetrate(bullet, wall, end_speed):
    bullet.energy = wall.energy + bullet.mass * (end_speed ** 2) / 2

    
    
    
    
    
class Двухкомпонентный_клей:
    def __init__( компонента_А, компонента_B ):
        if( компонента_А.химическое_вещество == "Дифенилолпропан" and \
        компонента_B.химическое_вещество == "Эпихлоргидрин"):
            self.агрегатное_состояние = "Твердое тело"
        else:
            self.агрегатное_состояние = "Жидкость"
            
    def обратный_конструктор(компонента_А, компонента_B, агрегатное_состояние ):
        компонента_А = self.компонента_А
        компонента_B = self.компонента_B
        агрегатное_состояние = self.агрегатное_состояние