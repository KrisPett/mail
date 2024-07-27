use std::io::Error;

use actix_web::{HttpResponse, post, web};
use serde::Deserialize;

use crate::services::mail_service;

#[derive(Deserialize)]
#[serde(rename_all = "camelCase")]
struct MessageRQ {
    course: String,
    name: String,
    email: String,
    company: String,
    phone: String,
    participants_desired: String,
    date: String,
}


#[post("/send-email")]
pub async fn send_email(message_rq: web::Json<MessageRQ>) -> Result<HttpResponse, Error> {
    log::info!("send_email");

    match mail_service::send_email(
        &message_rq.course,
        &message_rq.email,
        &message_rq.company,
        &message_rq.phone,
        &message_rq.participants_desired,
        &message_rq.date,
    ).await {
        Ok(_) => Ok(HttpResponse::Ok().json("send email completed")),
        Err(_) => Ok(HttpResponse::InternalServerError().json("Failed to send email")),
    }
}