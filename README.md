# 1-CursoSpring-Spring-Xml-Config
Demostración de configuración basada en xml para entender Spring y no solo hacer que funcione.

# Introducción a la Configuración de Spring y la Administración de Beans

Vamos a aprender Spring Framework y lo primero que conoceremos será el fundamento. Spring, como framework, nos ofrece muchas herramientas, pero lo primero es entender cómo funciona.

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
