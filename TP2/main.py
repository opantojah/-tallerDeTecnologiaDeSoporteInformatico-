import pandas as pd

# 1) Leer su archivo csv utilizando.
# 2) De ser posible, elegir una columna que pueda servir como índice y setearla como tal.
# 3) Eliminar las filas duplicadas
# 5) Eliminar las filas con valores que no sirven (espacios vacíos y "NaN")
# 7) Escribir un nuevo archivo .csv con las modificaciones realizadas
# 6) Colocar en forma de tabla, las primeras 3000 filas  y luego, las ultimas 2000.

if __name__ == '__main__':
    df = pd.read_csv("ejemplo.csv")

    dfIndexado = df.set_index("id")

    dfSinVacios = dfIndexado.dropna()

    dfSinDuplicados = dfSinVacios.drop_duplicates()

    df1 = dfSinDuplicados.iloc[0:3000]

    index1 = len(dfSinDuplicados) - 2001
    index2 = len(dfSinDuplicados) - 1

    df2 = dfSinDuplicados.iloc[index1: index2]

    dfFinal = pd.concat([df1,df2])

    print(len(dfFinal))

    dfFinal.to_csv("nuevo.csv")
