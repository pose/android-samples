(warning: spanish follows)

# Taller de Android

## Instalaci�n

### SDK

La primera parte de la clase, se destinar� a la configuraci�n del entorno. Para esto, se puede copiar desde pampero el SDK de Android:

    $ scp pampero:/tmp/android-sdk_r11-linux_x86.tgz .
    $ md5sum android-sdk_r11-linux_x86.tgz #Verificamos el checksum del archivo
    026c67f82627a3a70efb197ca3360d0a

Luego, se debe setear en el .bashrc lo siguiente:
    
    # exportamos ANDROID_HOME
    export ANDROID_HOME="<lugar donde descomprimieron el sdk>"

### Eclipse

Para que la integraci�n con Eclipse funcione se debe instalar el ADT. El Update Site es el siguiente:

    [[https://dl-ssl.google.com/android/eclipse/]]

### Descargar paquetes desde SDK

 # Por medio de la integraci�n con Eclipse, entrar a: `Window > Android SDK and AVD Manager`. 
 # Luego seleccionar: `Available Packages` y all� `Android Repository`
 # Seleccionar `SDK Platform Android 2.1-update1, API 7, revision 2`
 # Instalarlo


### Crear la m�quina virtual

Por �ltimo, se debe crear la m�quina virtual que emular� el dispositivo. Para esto, dentro de  `Window > Android SDK and AVD Manager` en `Virtual Devices` seleccionar `New` y crear una m�quina virtual llamada `hci` y con la opci�n `snapshot` habilitada.

## Clase de Taller

Se puede encontrar en [[aqu�|https://docs.google.com/present/view?id=dd2px4mb_447d6zdgkp9]].


