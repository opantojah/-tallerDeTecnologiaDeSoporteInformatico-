import pandas as pd


def pasarMinusculas(valor):
    if type(valor) == str:
        return valor.lower()
    else:
        return valor


def sacarEspacios():  # buscar funcion data['columna'].str.strip()
    pass


# quitar filas null
def pesoSoloNumero(valor):
    valor = str(valor)
    for caracter in valor:
        if not caracter.isnumeric():
            valor = valor.split(caracter, 1)
    return valor


def generalizarSexos(valor):
    valor = str(valor)
    valor.lower()
    if valor.startswit('m') or valor.startswith('h'):
        valor = valor[0]
    elif valor.startswith('no binarie'):
        valor = 'nb'
    else:
        valor = None  # no se si esto es asi
    return valor


def pasarFloatPromedios(valor):
    valor = float(valor)
    return valor


def arreglarLU(valor):
    valor = str(valor)
    primerCaracter = bool(1)
    for caracter in valor:
        if not caracter.isnumeric() and caracter != "/" and primerCaracter:
            valor = valor.replace(caracter, '/')
            primerCaracter = 0
        elif not caracter.isnumeric() and not primerCaracter:
            valor = valor.split(caracter, 1)
        print(valor)
    return valor


if __name__ == '__main__':
    data = pd.read_csv("data/datos.csv", sep=',', skipinitialspace=True, engine='python')
    data = data.applymap(pasarMinusculas)
    data.to_csv('data/nuevo.csv')
