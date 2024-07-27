package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"mail-go/internal/helpers"
	"mail-go/internal/routes/mail"
)

func main() {
	helpers.InitEnv()

	router := gin.Default()

	mail.RegisterEmailRoutes(router)

	if err := router.Run(":8080"); err != nil {
		fmt.Println("Error:", err)
	}
}
