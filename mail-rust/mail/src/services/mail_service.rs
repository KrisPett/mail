use std::io::Error;

use log::info;

pub async fn send_email(course: &String, email: &String, company: &String, phone: &String, participants_desired: &String, date: &String) -> Result<(), Error> {
    info!("Sending email with the following details:");
    info!("Course: {}", course);
    info!("Email: {}", email);
    info!("Company: {}", company);
    info!("Phone: {}", phone);
    info!("Participants Desired: {}", participants_desired);
    info!("Date: {}", date);
    Ok(())
}