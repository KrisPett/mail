package mail

import (
	"github.com/gin-gonic/gin"
	"log"
	"mail-go/internal/services"
	"net/http"
)

type MessageRQ struct {
	Course              string `json:"course"`
	Name                string `json:"name"`
	Email               string `json:"email"`
	Company             string `json:"company"`
	Phone               string `json:"phone"`
	ParticipantsDesired string `json:"participantsDesired"`
	Date                string `json:"date"`
}

func RegisterEmailRoutes(router *gin.Engine) {
	router.POST("/send-email", sendEmail)
}

func sendEmail(c *gin.Context) {
	log.Println("sendEmail")
	var messageRQ MessageRQ
	if err := c.ShouldBindJSON(&messageRQ); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}

	err := services.SendEmail(
		messageRQ.Course,
		messageRQ.Email,
		messageRQ.Company,
		messageRQ.Phone,
		messageRQ.ParticipantsDesired,
		messageRQ.Date,
	)
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": "Failed to send email"})
		return
	}

	c.JSON(200, "send email completed")
}
