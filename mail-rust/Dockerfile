FROM rust:1.77.2 as build

RUN USER=root cargo new --bin app
WORKDIR /app

COPY ./Cargo.lock ./Cargo.lock
COPY ./Cargo.toml ./Cargo.toml
COPY ./src ./src
COPY ./.env ./.env
COPY ./mail ./mail

WORKDIR /app/mail

RUN cargo build --release

FROM rust:1.77.2

COPY --from=build /app/target/release/mail .
COPY ./.env ./.env

EXPOSE 8080
CMD ["./mail"]
