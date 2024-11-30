# Text Processor API

## Descripción

Este proyecto es una API REST que procesa archivos `.txt` enviados a través de un endpoint. Analiza cada línea del archivo, realiza transformaciones en el texto y devuelve un resultado formateado. Además, incluye endpoints para verificar el estado del servicio.

## Características

- **Procesamiento de texto:**
  - Recibe un archivo `.txt` con líneas que contienen un número y una frase separados por `\`.
  - Elimina caracteres no alfabéticos y valida si el número coincide con la cantidad de palabras en la frase.
- **Validaciones:**
  - Manejo de archivos vacíos y errores de formato.
- **Endpoints de salud:**
  - Verificación de disponibilidad y estado del servicio (`/health/live` y `/health/ready`).

---

## Instalación y Ejecución Local

### **1. Prerrequisitos**
- Tener **Java 17**
- Tener **Maven** instalado.
- Puerto `8081` libre en tu máquina.

## Construir el proyecto
mvn clean install


## Ejecutar aplicación
mvn spring-boot:run

## Endpoints

1. Procesar Archivo
URL: POST /api/process
Descripción: Recibe un archivo .txt y procesa su contenido.
Consumo: multipart/form-data
Parámetro:file (obligatorio): Archivo .txt que contiene las líneas a procesar.
Respuesta: Devuelve un texto con las transformaciones aplicadas.


2. Endpoint de Liveness
URL: GET /health/live
Descripción: Verifica si el servicio está vivo.
Respuesta: "Service is alive".

3. Endpoint de Readiness
URL: GET /health/ready
Descripción: Verifica si el servicio está listo para procesar solicitudes.
Respuesta:"Service is ready to process files" si el servicio está listo.
Código HTTP 503 si el servicio no está listo.


#Pruebas
El proyecto incluye pruebas unitarias y de integración para validar el correcto funcionamiento de la API. Para ejecutar las pruebas, usa el siguiente comando:
mvn test

