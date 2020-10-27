-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Окт 27 2020 г., 07:16
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
  `dateTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `backup`
--

INSERT INTO `backup` (`id`, `files_id`, `action1`, `kto_sdelal_employeeId`, `komu_sdelali_employeeId`, `dateTime`) VALUES
(29, 76, 'Файл удален у Сотрудника', 1, 2, '2020-10-21 04:56:45'),
(31, 72, 'Файл удален у Сотрудника', 1, 2, '2020-10-21 05:15:00');

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
(72, 'Word41.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server\\FilesRepository\\HR\\Word41.docx', 'Внутренние Документы'),
(73, '01л.с. 05.01.20 увал, отпуск, назначение.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/01л.с. 05.01.20 увал, отпуск, назначение.docx', 'Командировки'),
(74, 'tetsPPTX.pptx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/BackUpFiles/tetsPPTX.pptx', 'Командировки'),
(75, 'edit1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/BackUpFiles/edit1.docx', 'Корреспонденция Вход'),
(76, '02л.с. 08.01.20 Змейков отпуск.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server\\FilesRepository\\HR\\02л.с. 08.01.20 Змейков отпуск.docx', 'Корреспонденция Исход'),
(77, 'testVlada.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server\\FilesRepository\\HR\\testVlada.docx', 'Личный Состав'),
(78, '1ку.xlsx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/BackUpFiles/1ку.xlsx', 'Производство'),
(79, 'sta1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/sta1.docx', 'Командировки'),
(80, 'testCreation1.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/testCreation1.docx', 'Командировки'),
(81, 'testCrt2.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/testCrt2.docx', 'Корреспонденция Вход'),
(82, 'testcrt3.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/testcrt3.docx', 'Личный состав'),
(83, 'kkkkk.docx', 'C:\\Users\\User\\Desktop\\Programming\\Java\\Digital_Workers_Server/FilesRepository/HR/kkkkk.docx', 'Корреспонденция Вход');

-- --------------------------------------------------------

--
-- Структура таблицы `file_to_human`
--

CREATE TABLE `file_to_human` (
  `id` int(11) NOT NULL,
  `id_employee` int(11) NOT NULL,
  `id_file` int(11) NOT NULL,
  `editOrNo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `file_to_human`
--

INSERT INTO `file_to_human` (`id`, `id_employee`, `id_file`, `editOrNo`) VALUES
(441, 3, 72, 0),
(442, 3, 73, 0),
(443, 3, 74, 0),
(444, 3, 75, 0),
(445, 3, 76, 0),
(446, 3, 77, 0),
(447, 3, 78, 0),
(448, 2, 72, 1),
(449, 2, 74, 0),
(450, 2, 75, 0),
(451, 2, 76, 1),
(452, 2, 77, 0),
(453, 2, 78, 0),
(454, 2, 73, 0),
(455, 1, 72, 0),
(456, 1, 74, 0),
(457, 1, 77, 0),
(458, 1, 75, 0),
(459, 1, 76, 0),
(460, 1, 78, 0),
(461, 1, 73, 0),
(462, 1, 79, 0),
(463, 1, 80, 0),
(464, 3, 80, 0),
(465, 2, 81, 0),
(466, 3, 81, 0),
(467, 1, 82, 0),
(468, 2, 82, 0),
(469, 3, 83, 0);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT для таблицы `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `files`
--
ALTER TABLE `files`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT для таблицы `file_to_human`
--
ALTER TABLE `file_to_human`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=470;

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
