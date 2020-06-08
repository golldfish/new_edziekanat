-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Czas generowania: 08 Cze 2020, 22:31
-- Wersja serwera: 8.0.20
-- Wersja PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `Test`
--
CREATE DATABASE IF NOT EXISTS `Test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `Test`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grupa`
--

CREATE TABLE `grupa` (
  `id_grupa` int NOT NULL,
  `kierunek` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `grupa`
--

INSERT INTO `grupa` (`id_grupa`, `kierunek`) VALUES
(1000, 'Informatyka'),
(1001, 'Informatyka');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grupa_przedmiot`
--

CREATE TABLE `grupa_przedmiot` (
  `id_grupa` int NOT NULL,
  `id_przedmiot` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `grupa_przedmiot`
--

INSERT INTO `grupa_przedmiot` (`id_grupa`, `id_przedmiot`) VALUES
(1000, 10),
(1001, 10),
(1000, 11),
(1001, 11),
(1000, 12),
(1001, 12),
(1000, 13),
(1000, 14),
(1000, 15),
(1000, 16);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ocena`
--

CREATE TABLE `ocena` (
  `id_ocena` int NOT NULL,
  `ocena` double DEFAULT NULL,
  `nr_albumu` int NOT NULL,
  `id_przedmiot` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `ocena`
--

INSERT INTO `ocena` (`id_ocena`, `ocena`, `nr_albumu`, `id_przedmiot`) VALUES
(10000, 5, 1000, 15),
(10001, 4, 1000, 16),
(10002, 4, 1000, 11),
(10003, 4, 1000, 12),
(10004, 4.5, 1000, 14),
(10005, 3, 1000, 15),
(10006, 5, 1003, 10),
(10007, 5, 1003, 11),
(10008, 5, 1003, 12),
(10009, 5, 1003, 13),
(10010, 5, 1003, 14),
(10011, 5, 1003, 15),
(10012, 5, 1003, 16),
(10013, 5, 1000, 15),
(10014, 5, 1000, 16),
(10015, 5, 1000, 16),
(10016, 5, 1000, 11),
(10017, 4, 1000, 11),
(10018, 4, 1000, 12),
(10019, 4, 1000, 12),
(10020, 5, 1000, 14),
(10021, 5, 1000, 14),
(10022, 3, 1001, 10),
(10023, 3, 1002, 10),
(10024, 3.5, 1001, 10),
(10025, 4, 1001, 10),
(10026, 3.5, 1001, 11),
(10027, 3.5, 1001, 11),
(10028, 3, 1001, 11),
(10029, 3, 1001, 12),
(10030, 3, 1001, 12),
(10031, 3, 1001, 12),
(10032, 3, 1002, 10),
(10033, 4, 1002, 10),
(10034, 5, 1002, 10),
(10035, 5, 1002, 11),
(10036, 4, 1002, 11),
(10037, 3, 1002, 11),
(10038, 4, 1002, 12),
(10039, 3, 1002, 12),
(10040, 5, 1002, 12);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `plan_zajec`
--

CREATE TABLE `plan_zajec` (
  `id_plan_zajec` int NOT NULL,
  `id_grupa` int NOT NULL,
  `id_przedmiot` int NOT NULL,
  `data` date NOT NULL,
  `data_czas_od` time NOT NULL,
  `data_czas_do` time NOT NULL,
  `sala` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `plan_zajec`
--

INSERT INTO `plan_zajec` (`id_plan_zajec`, `id_grupa`, `id_przedmiot`, `data`, `data_czas_od`, `data_czas_do`, `sala`) VALUES
(50, 1000, 15, '2020-06-08', '08:00:00', '09:30:00', 15),
(51, 1000, 15, '2020-06-09', '08:00:00', '09:30:00', 150),
(52, 1000, 16, '2020-06-10', '08:00:00', '09:30:00', 225),
(53, 1000, 14, '2020-06-11', '08:00:00', '09:30:00', 226),
(55, 1000, 12, '2020-06-08', '10:00:00', '11:30:00', 150),
(56, 1000, 13, '2020-06-09', '10:00:00', '11:30:00', 15),
(57, 1000, 11, '2020-06-10', '10:00:00', '11:30:00', 10),
(58, 1000, 10, '2020-06-11', '10:00:00', '11:30:00', 333),
(59, 1001, 10, '2020-06-08', '08:00:00', '09:35:00', 103),
(60, 1001, 11, '2020-06-08', '09:40:00', '11:25:00', 10),
(61, 1001, 12, '2020-06-08', '11:30:00', '13:00:00', 215),
(62, 1001, 10, '2020-06-09', '13:30:00', '15:10:00', 207),
(63, 1001, 12, '2020-06-09', '15:10:00', '16:35:00', 11),
(64, 1001, 11, '2020-06-10', '08:00:00', '09:35:00', 103);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmiot`
--

CREATE TABLE `przedmiot` (
  `id_przedmiot` int NOT NULL,
  `nazwa_przedmiot` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `przedmiot`
--

INSERT INTO `przedmiot` (`id_przedmiot`, `nazwa_przedmiot`) VALUES
(10, 'Matematyka'),
(11, 'Statystyka'),
(12, 'Bazy danych'),
(13, 'Inżynieria Oprogramowania'),
(14, 'Podstawy Transmisji Danych'),
(15, 'Automatyka'),
(16, 'Pneumatyka');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmiot_wykladowca`
--

CREATE TABLE `przedmiot_wykladowca` (
  `id_przedmiot` int NOT NULL,
  `id_wykladowca` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `przedmiot_wykladowca`
--

INSERT INTO `przedmiot_wykladowca` (`id_przedmiot`, `id_wykladowca`) VALUES
(12, 1000),
(13, 1000),
(14, 1000),
(15, 1000),
(16, 1000),
(10, 1001),
(11, 1001),
(12, 1001),
(13, 1001);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `student`
--

CREATE TABLE `student` (
  `nr_albumu` int NOT NULL,
  `imie` varchar(20) NOT NULL,
  `nazwisko` varchar(40) NOT NULL,
  `semestr` int NOT NULL,
  `kierunek` varchar(20) NOT NULL,
  `stopien` varchar(20) NOT NULL,
  `forma` varchar(20) NOT NULL,
  `wydzial` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `punkty_ECTS` int NOT NULL,
  `id_grupa` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `student`
--

INSERT INTO `student` (`nr_albumu`, `imie`, `nazwisko`, `semestr`, `kierunek`, `stopien`, `forma`, `wydzial`, `email`, `punkty_ECTS`, `id_grupa`) VALUES
(1000, 'Aleksandra', 'Kowalska', 2, 'Informatyka', 'Inżynier', 'Niestacjonarne', 'Informatyka', 'aleksandra.k@gmail.com', 30, 1000),
(1001, 'Ola', 'Badocha', 4, 'Informatyka', 'Inżynier', 'Stacjonarne', 'Informatyka', 'ola.badocha@mail.com', 33, 1001),
(1002, 'Marcin', 'Badocha', 4, 'Informatyka', 'Inżynier', 'Stacjonarne', 'Informatyka', 'marcin.badocha@mail.com', 115, 1001),
(1003, 'Igor', 'Gango', 1, 'Informatyka', 'Inżynier', 'Niestacjonarne', 'Informatyka', 'igor.gango@mail.com', 0, 1000),
(1004, 'Max', 'Kolonko', 3, 'Informatyka', 'Magister', 'Stacjonarne', 'Informatyka', 'max.kolonko@mail.com', 45, 1001);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wykladowca`
--

CREATE TABLE `wykladowca` (
  `id_wykladowca` int NOT NULL,
  `imie` varchar(30) NOT NULL,
  `nazwisko` varchar(50) NOT NULL,
  `wydzial` varchar(40) NOT NULL,
  `tytul_naukowy` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `wykladowca`
--

INSERT INTO `wykladowca` (`id_wykladowca`, `imie`, `nazwisko`, `wydzial`, `tytul_naukowy`, `email`) VALUES
(1000, 'Marian', 'Nowak', 'Informatyka', 'Dr Inż.', 'marian.pazdzioch@mail.com'),
(1001, 'Anna', 'Kreatywna', 'Informatyka', 'Mgr Inż.', 'anna.kreatywna@mail.com');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `grupa`
--
ALTER TABLE `grupa`
  ADD PRIMARY KEY (`id_grupa`);

--
-- Indeksy dla tabeli `grupa_przedmiot`
--
ALTER TABLE `grupa_przedmiot`
  ADD PRIMARY KEY (`id_grupa`,`id_przedmiot`),
  ADD KEY `gp_fk_przedmiot` (`id_przedmiot`);

--
-- Indeksy dla tabeli `ocena`
--
ALTER TABLE `ocena`
  ADD PRIMARY KEY (`id_ocena`),
  ADD KEY `nr_studenta` (`nr_albumu`),
  ADD KEY `id_przedmiotu` (`id_przedmiot`);

--
-- Indeksy dla tabeli `plan_zajec`
--
ALTER TABLE `plan_zajec`
  ADD PRIMARY KEY (`id_plan_zajec`),
  ADD KEY `id_grupa` (`id_grupa`),
  ADD KEY `id_przedmiot` (`id_przedmiot`);

--
-- Indeksy dla tabeli `przedmiot`
--
ALTER TABLE `przedmiot`
  ADD PRIMARY KEY (`id_przedmiot`);

--
-- Indeksy dla tabeli `przedmiot_wykladowca`
--
ALTER TABLE `przedmiot_wykladowca`
  ADD PRIMARY KEY (`id_przedmiot`,`id_wykladowca`),
  ADD KEY `pw_fk_wykladowca` (`id_wykladowca`);

--
-- Indeksy dla tabeli `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`nr_albumu`),
  ADD KEY `s_fk_grupa` (`id_grupa`);

--
-- Indeksy dla tabeli `wykladowca`
--
ALTER TABLE `wykladowca`
  ADD PRIMARY KEY (`id_wykladowca`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `grupa`
--
ALTER TABLE `grupa`
  MODIFY `id_grupa` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- AUTO_INCREMENT dla tabeli `ocena`
--
ALTER TABLE `ocena`
  MODIFY `id_ocena` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10041;

--
-- AUTO_INCREMENT dla tabeli `przedmiot`
--
ALTER TABLE `przedmiot`
  MODIFY `id_przedmiot` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT dla tabeli `student`
--
ALTER TABLE `student`
  MODIFY `nr_albumu` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1005;

--
-- AUTO_INCREMENT dla tabeli `wykladowca`
--
ALTER TABLE `wykladowca`
  MODIFY `id_wykladowca` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `grupa_przedmiot`
--
ALTER TABLE `grupa_przedmiot`
  ADD CONSTRAINT `gp_fk_grupa` FOREIGN KEY (`id_grupa`) REFERENCES `grupa` (`id_grupa`),
  ADD CONSTRAINT `gp_fk_przedmiot` FOREIGN KEY (`id_przedmiot`) REFERENCES `przedmiot` (`id_przedmiot`);

--
-- Ograniczenia dla tabeli `ocena`
--
ALTER TABLE `ocena`
  ADD CONSTRAINT `id_przedmiotu` FOREIGN KEY (`id_przedmiot`) REFERENCES `przedmiot` (`id_przedmiot`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `nr_studenta` FOREIGN KEY (`nr_albumu`) REFERENCES `student` (`nr_albumu`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Ograniczenia dla tabeli `plan_zajec`
--
ALTER TABLE `plan_zajec`
  ADD CONSTRAINT `id_grupa` FOREIGN KEY (`id_grupa`) REFERENCES `grupa` (`id_grupa`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `id_przedmiot` FOREIGN KEY (`id_przedmiot`) REFERENCES `przedmiot` (`id_przedmiot`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Ograniczenia dla tabeli `przedmiot_wykladowca`
--
ALTER TABLE `przedmiot_wykladowca`
  ADD CONSTRAINT `pw_fk_przedmiot` FOREIGN KEY (`id_przedmiot`) REFERENCES `przedmiot` (`id_przedmiot`),
  ADD CONSTRAINT `pw_fk_wykladowca` FOREIGN KEY (`id_wykladowca`) REFERENCES `wykladowca` (`id_wykladowca`);

--
-- Ograniczenia dla tabeli `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `s_fk_grupa` FOREIGN KEY (`id_grupa`) REFERENCES `grupa` (`id_grupa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
