package services

import (
	"fmt"
	"log"
	"net/smtp"
	"os"
)

func SendEmail(course, email, company, phone, participantsDesired, date string) error {
	username := os.Getenv("SMTP_USERNAME")
	password := os.Getenv("SMTP_PASSWORD")
	smtpHost := os.Getenv("SMTP_HOST")
	smtpPort := os.Getenv("SMTP_PORT")
	from := "mailtrap@demomailtrap.com"
	to := "koffep@gmail.com"

	smtpUrl := fmt.Sprintf("%s:%s", smtpHost, smtpPort)

	auth := smtp.PlainAuth("", username, password, smtpHost)

	message := fmt.Sprintf(
		"To: %s\r\n"+
			"From: %s\r\n"+
			"Subject: Course Information\r\n"+
			"Content-Type: text/html; charset=\"UTF-8\"\r\n"+
			"\r\n"+
			"<html><body>"+
			"<p>Course: %s<br>"+
			"Email: %s<br>"+
			"Company: %s<br>"+
			"Phone: %s<br>"+
			"Participants Desired: %s<br>"+
			"Date: %s<br>"+
			"</p></body></html>",
		to, from, course, email, company, phone, participantsDesired, date)

	err := smtp.SendMail(smtpUrl, auth, from, []string{to}, []byte(message))
	if err != nil {
		log.Println("Failed to send email:", err)
		return err
	}

	log.Println("Email sent successfully")
	return nil
}
