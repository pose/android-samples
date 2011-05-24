# Taller de Android

El objetivo del taller es poder configurar el entorno necesario para el desarrollo de aplicaciones en la plataforma Android.  

## Instalación

### SDK

La primera parte de la clase, se destinará a la configuración del entorno. Para esto, se puede copiar desde pampero el SDK de Android:

    $ scp pampero:/tmp/android-sdk_r11-linux_x86.tgz .
    $ md5sum android-sdk_r11-linux_x86.tgz #Verificamos el checksum del archivo
    026c67f82627a3a70efb197ca3360d0a

### Eclipse

Para que la integración con Eclipse funcione se debe instalar el ADT. El Update Site es el siguiente:

	https://dl-ssl.google.com/android/eclipse/

Luego, se debe especificar el path donde se encuentra el SDK para que el ADT lo encuentre.

### Descargar paquetes desde SDK

 1. Por medio de la integración con Eclipse, entrar a: `Window > Android SDK and AVD Manager`. 
 2. Luego seleccionar: `Available Packages` y allí `Android Repository`
 3. Seleccionar `SDK Platform Android 2.1-update1, API 7, revision 2`
 4. Instalarlo


### Crear la máquina virtual

Por último, se debe crear la máquina virtual que emulará el dispositivo. Para esto, dentro de  `Window > Android SDK and AVD Manager` en `Virtual Devices` seleccionar `New` y crear una máquina virtual llamada `hci` y con la opción `snapshot` habilitada.

### Troubleshooting

 * En caso de que no esté funcionando el proyecto realizar un `Clean` del mismo. 
 * En caso de que el proyecto no esté reconociendo el objeto `R`, deshabilitar temporalmente el build automático y hacer `Clean`. Volver a habilitar el build automático.
 * En caso de que el proyecto siga teniendo errores: Revisar la solapa `Problems` y en caso de que el error parezca que tiene que ver con que el compilador no soporta annotations: Hacer click derecho en el proyecto que se encuentra a la izquierda, ir a `Properties` y buscar `Compiler`. Cambiar las opciones en esa solapa y verificar que se esté soportando la versión `1.6`.


## Clase de Taller

Se puede encontrar [aquí](https://docs.google.com/present/view?id=dd2px4mb_447d6zdgkp9).

