# Password Vault (Java Console Application)

## Overview
A console-based Java application to securely store, view, update, and delete passwords. Uses **JDBC** for MySQL database connection and **AES encryption** for password security.

## Features
- Master password protection
- Add, view, update, delete passwords
- AES encryption for secure storage
- Console menu-driven interface

## Project Structure

DBConnection.java
AESUtil.java
MasterPasswordService.java
PasswordVaultService.java
SetupMasterUI.java
LoginUI.java
AddPasswordUI.java
ViewPasswordUI.java
UpdatePasswordUI.java
DeletePasswordUI.java
DashboardUI.java
Main.java


## Database Setup
```sql
CREATE DATABASE password_vault;
USE password_vault;

CREATE TABLE master_password(
    id INT PRIMARY KEY AUTO_INCREMENT,
    password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE vault(
    id INT PRIMARY KEY AUTO_INCREMENT,
    site VARCHAR(100),
    username VARCHAR(100),
    password_enc VARCHAR(255)
);

Open-source project. Feel free to use and modify.

