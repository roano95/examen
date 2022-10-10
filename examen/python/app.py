from transformations.functions import Functions

class App:
    def __init__(self):
        """
        Clase que contiene los metodos a usar
        """
    
    def main():
        function = Functions()
        saldo = 0
        nombre = input("Ingrese su nombre de usaurio: ")
        check = False
        for i in range(3):
            password = input("Ingrese la contraseña por favor: ")
            check = function.validar_pass(password)
            if i >= 3:
                break
            if check:
                print("Ingreso correcto")
                print(f"Hola, Bienvenido {nombre}")   
                break             
        while check:
            print("   .:MENU:.")
            print("1. Consultar saldo")
            print("2. Retirar Saldo")
            print("3: Ingresar saldo")
            print("4: Histórico de Movimientos")
            print("5: Salir")
            opcion = int(input("Eliga una opción: "))
            if opcion == 1:
                saldo = function.consultar_saldo()
                print(saldo)
            elif opcion == 2:
                retiro = float(input("Dinero a retirar: "))
                isRetiro = function.retirar_saldo(retiro)
                if isRetiro:
                    print("Retiro correcto")
                else:
                    print("Validar saldo, no se tienen fondos suficientes")
            elif opcion == 3:
                ingreso = float(input("Dinero a ingresar: "))
                function.ingresar_saldo(ingreso)
            elif opcion == 4:
                print(function.consulta_movimientos())
            elif opcion == 5:
                break
            else:
                print("Ingrese una opción correcta")
            
    main()