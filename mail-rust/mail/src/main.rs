use actix_web::{App, HttpServer, middleware};

use routes::mail;

mod routes;
mod services;

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    env_logger::init_from_env(env_logger::Env::new().default_filter_or("info"));

    HttpServer::new(move || {
        App::new()
            .wrap(middleware::Logger::default())
            .configure(mail::init_routes)
    })
        .bind(("0.0.0.0", 8080))?
        .run()
        .await
}
