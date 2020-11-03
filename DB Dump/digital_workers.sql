-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Ноя 03 2020 г., 06:20
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
  `action1` varchar(45) NOT NULL,
  `kto_sdelal_employeeId` int(11) NOT NULL,
  `komu_sdelali_employeeId` int(11) DEFAULT NULL,
  `dateTime` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `backup`
--

INSERT INTO `backup` (`id`, `files_id`, `action1`, `kto_sdelal_employeeId`, `komu_sdelali_employeeId`, `dateTime`) VALUES
(39, 76, 'Файл удален у всех сотрудников', 1, NULL, '2020-10-30 03:23:45'),
(43, 79, 'Файл удален у всех сотрудников', 1, NULL, '2020-10-30 06:50:25');

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
(2, 'Эльдар', 'Эрикжанович', 'Козбагаров', '+77017412221', 'HR', '20.06.2020', '1663202', 'leonArmani', 'dog2', 'test@gmail.com'),
(3, 'Влада', 'Владиславовна', 'Башева', '+77081907101', 'test', 'test', '1509442', 'vlada', 'test', 'test'),
(4, 'test', 'test', 'test', 'test', 'test', 'test', '12908', 'test', 'test', 'test'),
(5, 'test', 'test', 'test', 'test', 'test', 'test', '12908', 'test', 'test', 'test'),
(6, 'test', 'test', 'test', 'test', 'test', 'test', '12908', 'test', 'test', 'test'),
(7, 'test', 'test', 'test', 'test', 'test', 'test', '12908', 'test', 'test', 'test');

-- --------------------------------------------------------

--
-- Структура таблицы `files`
--

CREATE TABLE `files` (
  `id` int(11) NOT NULL,
  `name1` varchar(45) NOT NULL,
  `path1` varchar(300) NOT NULL,
  `type1` varchar(45) NOT NULL,
  `dateTime` datetime DEFAULT current_timestamp(),
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `files`
--

INSERT INTO `files` (`id`, `name1`, `path1`, `type1`, `dateTime`, `description`) VALUES
(72, 'Word101.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/Word101.docx', 'Внутренние Документы', '2020-10-07 09:45:09', NULL),
(73, '01л.с. 05.01.20 увал, отпуск, назначение.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/01л.с. 05.01.20 увал, отпуск, назначение.docx', 'Производство', '2020-10-30 09:45:18', NULL),
(74, 'tetsPPTX.pptx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/tetsPPTX.pptx', 'Командировки', '2020-10-30 09:45:27', NULL),
(75, 'edit1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/BackUpFiles/edit1.docx', 'Корреспонденция Вход', '2020-10-30 09:45:30', NULL),
(76, '02л.с. 08.01.20 Змейков отпуск.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/BackUpFiles/02л.с. 08.01.20 Змейков отпуск.docx', 'Корреспонденция Исход', '2020-10-30 09:45:49', NULL),
(77, 'testVlada.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/testVlada.docx', 'Командировки', '2020-10-30 09:45:52', NULL),
(78, '1ку.xlsx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/1ку.xlsx', 'Личный состав', '2020-10-30 09:45:55', NULL),
(79, 'sta1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/BackUpFiles/sta1.docx', 'Производство', '2020-10-30 09:45:57', NULL),
(80, 'testFedos11.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/BackUpFiles/testFedos11.docx', 'Личный состав', '2020-10-14 09:46:00', NULL),
(81, 'testCrt2.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/testCrt2.docx', 'Корреспонденция Вход', '2020-10-02 09:46:02', NULL),
(82, 'testcrt3.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/testcrt3.docx', 'Личный состав', '2020-10-10 09:46:04', NULL),
(83, 'kkkkk.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/kkkkk.docx', 'Корреспонденция Вход', '2020-10-15 09:46:06', NULL),
(84, 'dad.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/dad.docx', 'Корреспонденция Исход', '2020-10-12 09:46:11', NULL),
(85, '3.8.8-lab---explore-dns-traffic.pdf', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/3.8.8-lab---explore-dns-traffic.pdf', 'Производство', '2020-10-29 16:04:58', NULL),
(86, 'wer1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/wer1.docx', 'Производство', '2020-10-29 17:03:08', NULL),
(87, 'testzhurnal1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/testzhurnal1.docx', 'Командировки', '2020-10-29 17:39:34', NULL),
(88, 'testDescCreate1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/testDescCreate1.docx', 'Командировки', '2020-10-30 10:44:53', 'firstTestDescription'),
(89, '3.5.7-lab---social-engineering.pdf', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/3.5.7-lab---social-engineering.pdf', 'Внутренние Документы', '2020-10-31 15:12:48', NULL),
(90, 'reqExeTest1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/reqExeTest1.docx', 'Командировки', '2020-10-31 15:28:37', 'reqExeTest1'),
(91, '12ara.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/12ara.docx', 'Командировки', '2020-11-02 20:24:36', 'cdvdsvsdv'),
(92, 'Alimtest.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/Alimtest.docx', 'Командировки', '2020-11-02 20:52:56', ''),
(93, 'testTime1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/testTime1.docx', 'Командировки', '2020-11-03 04:25:28', 'testTime1');

-- --------------------------------------------------------

--
-- Структура таблицы `file_to_human`
--

CREATE TABLE `file_to_human` (
  `id` int(11) NOT NULL,
  `id_employee` int(11) NOT NULL,
  `id_file` int(11) NOT NULL,
  `editOrNo` tinyint(1) NOT NULL DEFAULT 0,
  `delOrNo` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `file_to_human`
--

INSERT INTO `file_to_human` (`id`, `id_employee`, `id_file`, `editOrNo`, `delOrNo`) VALUES
(441, 3, 72, 0, 0),
(442, 3, 73, 0, 0),
(443, 3, 74, 0, 0),
(444, 3, 75, 0, 0),
(445, 3, 76, 1, 0),
(446, 3, 77, 0, 0),
(447, 3, 78, 0, 0),
(448, 2, 72, 0, 0),
(449, 2, 74, 0, 0),
(450, 2, 75, 0, 0),
(451, 2, 76, 1, 0),
(452, 2, 77, 0, 0),
(453, 2, 78, 0, 0),
(454, 2, 73, 0, 0),
(455, 1, 72, 0, 0),
(456, 1, 74, 0, 0),
(457, 1, 77, 0, 0),
(458, 1, 75, 0, 0),
(459, 1, 76, 1, 0),
(460, 1, 78, 0, 0),
(461, 1, 73, 0, 0),
(462, 1, 79, 1, 0),
(463, 1, 80, 0, 0),
(464, 3, 80, 0, 0),
(465, 2, 81, 0, 0),
(466, 3, 81, 0, 0),
(467, 1, 82, 0, 0),
(468, 2, 82, 0, 0),
(469, 3, 83, 0, 0),
(470, 3, 84, 0, 0),
(471, 4, 84, 0, 0),
(472, 1, 85, 0, 0),
(473, 1, 86, 0, 0),
(474, 2, 86, 0, 0),
(475, 1, 87, 0, 0),
(476, 2, 87, 0, 0),
(477, 3, 87, 0, 0),
(478, 1, 88, 0, 0),
(479, 2, 88, 0, 0),
(480, 4, 88, 0, 0),
(481, 1, 89, 0, 0),
(482, 1, 90, 0, 0),
(483, 2, 90, 0, 0),
(484, 3, 90, 0, 0),
(485, 1, 91, 0, 0),
(486, 2, 91, 0, 0),
(487, 3, 91, 0, 0),
(488, 1, 92, 0, 0),
(489, 2, 92, 0, 0),
(490, 4, 92, 0, 0),
(491, 1, 93, 0, 0),
(492, 3, 93, 0, 0),
(493, 4, 93, 0, 0);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `backup`
--
ALTER TABLE `backup`
  ADD PRIMARY KEY (`id`),
  ADD KEY `backup_ibfk_1` (`files_id`),
  ADD KEY `backup_ibfk_2` (`kto_sdelal_employeeId`),
  ADD KEY `backup_ibfk_3` (`komu_sdelali_employeeId`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT для таблицы `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT для таблицы `files`
--
ALTER TABLE `files`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT для таблицы `file_to_human`
--
ALTER TABLE `file_to_human`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=494;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `backup`
--
ALTER TABLE `backup`
  ADD CONSTRAINT `backup_ibfk_1` FOREIGN KEY (`files_id`) REFERENCES `files` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `backup_ibfk_2` FOREIGN KEY (`kto_sdelal_employeeId`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `backup_ibfk_3` FOREIGN KEY (`komu_sdelali_employeeId`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
