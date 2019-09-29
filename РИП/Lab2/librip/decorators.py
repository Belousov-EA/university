def print_result(func):
    def wrapper(argv):
        print (func.__name__)
        result = func(argv)
        if type( result ) is list:
            for res in result:
                print ( res )
        elif type( result ) is dict:
            for key, value in result.items():
                print( "{0} = {1}".format( key, value ))
        else:
            print (result)
        return result
    return wrapper
