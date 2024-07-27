use actix_web::web;

pub mod mail_route;

pub fn init_routes(cfg: &mut web::ServiceConfig) {
    cfg.service(mail_route::send_email);
}
