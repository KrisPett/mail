use std::env;
use std::io::Error;

use lettre::{Message, SmtpTransport, Transport};
use lettre::transport::smtp::authentication::Credentials;

pub async fn send_email(course: &String, email: &String, company: &String, phone: &String, participants_desired: &String, date: &String) -> Result<(), Error> {
    let username = env::var("SMTP_USERNAME").expect("env not set");
    let password = env::var("SMTP_PASSWORD").expect("env not set");
    let smtp_host = env::var("SMTP_HOST").expect("env not set");
    let smtp_port = env::var("SMTP_PORT").expect("env not set");
    let from = "mailtrap@demomailtrap.com";
    let to = "koffep@gmail.com";

    let email = Message::builder()
        .from(from.parse().unwrap())
        .to(to.parse().unwrap())
        .subject("Course Information")
        .header(lettre::message::header::ContentType::TEXT_HTML)
        .body(format!(
            "<html><body>
            <p>Course: {}<br>
            Email: {}<br>
            Company: {}<br>
            Phone: {}<br>
            Participants Desired: {}<br>
            Date: {}<br>
            </p></body></html>",
            course, email, company, phone, participants_desired, date))
        .unwrap();

    let creds = Credentials::new(username, password);

    let mailer = SmtpTransport::starttls_relay(&*smtp_host)
        .unwrap()
        .port(smtp_port.parse().unwrap())
        .credentials(creds)
        .build();

    match mailer.send(&email) {
        Ok(_) => println!("Email sent successfully!"),
        Err(e) => eprintln!("Could not send email: {:?}", e),
    }

    Ok(())
}