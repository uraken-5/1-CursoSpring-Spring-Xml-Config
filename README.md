# Introducción a la Configuración de Spring y la Administración de Beans

Este proyecto presenta una configuración básica de Spring que demuestra la Inversión de Control (IoC) y la Inyección de Dependencia (DI) a través de un archivo XML. Exploraremos la configuración de beans y cómo Spring administra los objetos (beans) en nuestra aplicación.

En este repositorio veremos:
- El concepto de la **Inversión de Control** (IoC)
- **Inyección de Dependencia** (DI)
- Configuración de **beans** utilizando **XML**

No entraremos en mucho detalle, vamos a ir directo al código.

## Spring es una Fábrica de Beans

Explicado de forma simple, **Spring implementa una fábrica de beans**, un mecanismo complejo que le permite administrar los beans de una aplicación y entregárselos a quien lo requiera.

Para lograr esto, tenemos dos conceptos importantes:
- **BeanFactory** y **ApplicationContext**.

Estos conceptos los veremos directamente en el código para una mejor comprensión.

> **Un momento, ¿qué es un BEAN?**  
> Tranquilos... En Spring, los objetos que forman la columna vertebral de nuestra aplicación y que son administrados por el contenedor de Spring son conocidos como **BEANS**.  
> Un BEAN no es más que un objeto que es instanciado, ensamblado y administrado por el contenedor de Spring.

> **¿Entonces un bean no es más que un objeto?**  
> Pues sí, es solo un objeto.

## Vamos a Codificar

## Clases Principales

El proyecto cuenta con dos clases principales y un archivo XML que define la configuración de beans:

### Clase `Main`

```java
package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/ApplicationContext.xml");
		Saludo saludo = context.getBean(Saludo.class);
		saludo.saludoMañanero();
	}
}
```
#### Explicación:

- La clase `Main` actúa como el punto de entrada de la aplicación.
- Utiliza `ApplicationContext`, que es el contenedor de IoC provisto por Spring para manejar los beans.
- `FileSystemXmlApplicationContext` carga la configuración de Spring desde un archivo XML, en este caso `ApplicationContext.xml`, ubicado en `src/main/resources`.
- A través de `context.getBean(Saludo.class)`, recupera una instancia del bean `Saludo` definida en el archivo XML, que es luego utilizada para ejecutar el método `saludoMañanero`.

### Clase `Saludo`

```java
package com.example.demo;

public class Saludo {
	
	public void saludoMañanero() {
		System.out.println("Buenos Dias");
	}
}
```
### Explicacion:

- La clase Saludo representa un BEAN de Spring en este proyecto.
- Contiene un metodo simple, `saludoMañanero` que imprime "buenos dias" en la consola.
- Esta clase es instanciada y administrada por el contenedor de Spring, gracias a su definición como BEAN en el archivo ApplicationContext.xml.

### Archivo de configuración `ApplicationContext.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="
    http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans.xsd">
	  
  <bean id="saludo1" class="com.example.demo.Saludo">
  </bean>
	
</beans>
```
#### Explicación:

- Este archivo define los beans utilizados por el contenedor de Spring.
- El elemento `<bean>` crea un bean llamado `saludo1` de la clase `com.example.demo.Saludo`. Spring gestionará la instancia de `Saludo` como un bean dentro del contexto de la aplicación.
- La configuración XML permite a Spring inyectar y administrar las dependencias sin que `Main` tenga que instanciar directamente la clase `Saludo`, aplicando la Inversión de Control.

## Ejecución del Proyecto

Para ejecutar el proyecto:

1. Asegúrate de que el archivo `ApplicationContext.xml` esté en la ubicación correcta (`src/main/resources`).
2. Ejecuta el método `main` en la clase `Main`.
3. Deberías ver el mensaje `Buenos Dias` en la consola, lo que confirma que Spring ha gestionado exitosamente la creación y administración del bean `Saludo`.

Este es un ejemplo básico que muestra cómo Spring puede ser configurado para manejar beans en una aplicación, con una estructura sencilla que se presta para introducir IoC y DI en Spring.


