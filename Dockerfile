FROM python:3.10-slim

EXPOSE 8000

RUN pip install poetry

COPY . .

RUN poetry install --no-root


CMD ["poetry", "run", "python", "manage.py", "runserver", "0.0.0.0:8000"]