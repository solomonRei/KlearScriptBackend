# KlearScript - Backend

## About the Project

An App that scans the handwritten text and converts it into digital text. The app is built using Spring Boot, React, ML Python

### Key Features

- **Handwritten Text Recognition**: The core feature, utilizing TensorFlow and machine learning in Python. This allows the app to accurately scan and convert handwritten text into digital text.
- **Image Preprocessing**:  Advanced image processing capabilities to enhance the quality of scanned images before text recognition. This includes adjusting brightness, contrast, and removing noise, which improves accuracy.

## Installation Instructions

KlearScript can be easily set up using Docker. Below are the steps to install and run the application using Docker Compose.

1. Ensure you have Docker and Docker Compose installed on your system.
2. Create a Docker Compose file with the following configuration:

```yaml
version: '3'

services:
  postgres:
    image: postgres:latest
    container_name: postgres_db_new
    ports:
      - "5432:5432"
    environment:
      - POSTGRES_PASSWORD=postgres
      - POSTGRES_USER=postgres
      - POSTGRES_DB=postgres
    networks:
      - elc_wise

  app:
    image: smeloved/hackathonwritten:v1.0.1
    container_name: app_new
    ports:
      - "8080:8080"
    depends_on:
      - postgres
    networks:
      - elc_wise
    environment:
      - POSTGRES_URL=jdbc:postgresql://postgres_db_new:5432/postgres
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=postgres

networks:
  elc_wise:
```

3. Run the application using the command:
   ```
   docker-compose up
   ```
4. Once the services are up, access the application at `http://localhost:8080`.
