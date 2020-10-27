-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Сен 23 2020 г., 10:11
-- Версия сервера: 10.4.13-MariaDB
-- Версия PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `digital_workers`
--

-- --------------------------------------------------------

--
-- Структура таблицы `backup`
--

CREATE TABLE `backup` (
  `id` int(11) NOT NULL,
  `files_id` int(11) NOT NULL,
  `action` varchar(45) NOT NULL,
  `kto_sdelal_employeeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `middle_name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `dolzhnost` varchar(45) NOT NULL,
  `datePriema` varchar(15) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `trud_dogovor` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `employee`
--

INSERT INTO `employee` (`id`, `name`, `middle_name`, `surname`, `phone_number`, `dolzhnost`, `datePriema`, `pass`, `login`, `trud_dogovor`, `email`) VALUES
(1, 'Фёдор', 'Маркович', 'Сташин', '+77770281221', 'Администратор', '26.08.2020', '46792755', 'hazgar', 'dogovor1', 'fedorstashin123@gmail.com'),
(2, 'Эльдар', 'Эрикжанович', 'Козбагаров', '+77017412221', 'HR', '20.06.2020', '1509442', 'leonArmani', 'dog2', 'test@gmail.com'),
(3, 'Влада', 'Владиславовна', 'Башева', '+77081907101', 'test', 'test', '1509442', 'vlada', 'test', 'test');

-- --------------------------------------------------------

--
-- Структура таблицы `files`
--

CREATE TABLE `files` (
  `id` int(11) NOT NULL,
  `name1` varchar(45) NOT NULL,
  `path1` varchar(300) NOT NULL,
  `type1` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `files`
--

INSERT INTO `files` (`id`, `name1`, `path1`, `type1`) VALUES
(50, '1ку.xlsx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server\\FilesRepository\\HR\\1ку.xlsx', 'Внутренние Документы'),
(52, 'tetsPPTX.pptx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server\\FilesRepository\\HR\\tetsPPTX.pptx', 'Корреспонденция Вход'),
(53, 'testVlada.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server\\FilesRepository\\HR\\testVlada.docx', 'Корреспонденция Исход'),
(54, 'file111111.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/file111111.docx', 'Личный Состав'),
(55, 'textExcel.xlsx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/textExcel.xlsx', 'Внутренние Документы'),
(56, '02л.с. 08.01.20 Змейков отпуск.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/02л.с. 08.01.20 Змейков отпуск.docx', 'Командировки'),
(57, 'file2.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/file2.docx', 'Личный Состав'),
(58, 'edit1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/edit1.docx', 'Корреспонденция Исход'),
(59, '01л.с. 05.01.20 увал, отпуск, назначение.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server\\FilesRepository\\HR\\01л.с. 05.01.20 увал, отпуск, назначение.docx', 'Производство'),
(60, 'fileADD.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/fileADD.docx', 'Командировки'),
(61, 'тестЕдит.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/тестЕдит.docx', 'Внутренние Документы'),
(62, '12.7.2-lab---configure-single-area-ospfv2.pdf', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/12.7.2-lab---configure-single-area-ospfv2.pdf', 'Личный Состав'),
(63, 'tetes.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/tetes.docx', 'Командировки');

-- --------------------------------------------------------

--
-- Структура таблицы `file_to_human`
--

CREATE TABLE `file_to_human` (
  `id` int(11) NOT NULL,
  `id_employee` int(11) NOT NULL,
  `id_file` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `file_to_human`
--

INSERT INTO `file_to_human` (`id`, `id_employee`, `id_file`) VALUES
(396, 3, 50),
(398, 3, 52),
(399, 3, 53),
(400, 3, 54),
(401, 2, 55),
(403, 2, 56),
(404, 2, 57),
(405, 2, 58),
(406, 2, 54),
(407, 2, 59),
(408, 2, 60),
(409, 1, 55),
(411, 1, 56),
(412, 1, 57),
(413, 1, 58),
(414, 1, 54),
(415, 1, 59),
(416, 1, 60),
(417, 1, 61),
(418, 1, 62),
(419, 1, 63);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `backup`
--
ALTER TABLE `backup`
  ADD PRIMARY KEY (`id`),
  ADD KEY `backup_ibfk_1` (`files_id`),
  ADD KEY `backup_ibfk_2` (`kto_sdelal_employeeId`);

--
-- Индексы таблицы `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `files`
--
ALTER TABLE `files`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `file_to_human`
--
ALTER TABLE `file_to_human`
  ADD PRIMARY KEY (`id`),
  ADD KEY `file_to_human_ibfk_1` (`id_employee`) USING BTREE,
  ADD KEY `file_to_human_ibfk_2` (`id_file`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `backup`
--
ALTER TABLE `backup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `files`
--
ALTER TABLE `files`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT для таблицы `file_to_human`
--
ALTER TABLE `file_to_human`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=420;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `backup`
--
ALTER TABLE `backup`
  ADD CONSTRAINT `backup_ibfk_1` FOREIGN KEY (`files_id`) REFERENCES `files` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `backup_ibfk_2` FOREIGN KEY (`kto_sdelal_employeeId`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `file_to_human`
--
ALTER TABLE `file_to_human`
  ADD CONSTRAINT `file_to_human_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `file_to_human_ibfk_2` FOREIGN KEY (`id_file`) REFERENCES `files` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
