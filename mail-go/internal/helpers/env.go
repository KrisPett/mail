package helpers

import (
	"github.com/joho/godotenv"
	"log"
)

func InitEnv() {
	if err := godotenv.Load(".env"); err != nil {
		log.Fatal("Error loading .env file: ", err)
	}
}
