-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 02, 2024 at 09:59 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pidev`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id_quest` int(11) NOT NULL,
  `quest` varchar(255) DEFAULT NULL,
  `rep1` varchar(255) NOT NULL,
  `rep2` varchar(255) NOT NULL,
  `rep3` varchar(255) NOT NULL,
  `rep4` varchar(255) NOT NULL,
  `repc` varchar(255) NOT NULL,
  `quiz_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id_quest`, `quest`, `rep1`, `rep2`, `rep3`, `rep4`, `repc`, `quiz_id`) VALUES
(2102, 'Which of the following dice is not a platonic solid?', '12-sided die', '20-sided die', '8-sided die', '10-sided die', '10-sided die', 57),
(2103, 'What is the approximate value of mathematical constant e?', '3.14', '1.62', '1.41', '2.72', '2.72', 57),
(2104, 'What is the symbol for Displacement?', 'dr', 'Dp', 'r', 'Δr', 'Δr', 57),
(2105, 'Which of these numbers is closest to the total number of possible states for an army standard Enigma Machine?', '1.58 x 10^22', '1.58 x  10^18', '1.58 x 10^24', '1.58 x 10^20', '1.58 x 10^20', 57),
(2106, 'What is the area of a circle with a diameter of 20 inches if π= 3.1415?', '380.1215 Inches', '3141.5 Inches', '1256.6 Inches', '314.15 Inches', '314.15 Inches', 57),
(2107, 'What is the fourth digit of π?', '2', '3', '4', '1', '1', 57),
(2108, 'Which of the following famous mathematicians died in a duel at the age of 20?', 'Abel', 'Euler', 'Gauss', 'Galois', 'Galois', 57),
(2109, 'What are the first 6 digits of the number \"Pi\"?', '3.14169', '3.12423', '3.25812', '3.14159', '3.14159', 57),
(2110, 'What is the plane curve proposed by Descartes to challenge Fermat\'s extremum-finding techniques called?', 'Elliptic Paraboloid of Descartes', 'Cartesian Coordinates', 'Descarte\'s Helicoid', 'Folium of Descartes', 'Folium of Descartes', 57),
(2111, 'Which mathematician refused the Fields Medal?', 'Andrew Wiles', 'Terence Tao', 'Edward Witten', 'Grigori Perelman', 'Grigori Perelman', 57),
(2112, 'What was the nickname given to the Hughes H-4 Hercules, a heavy transport flying boat which achieved flight in 1947?', 'Noah\'s Ark', 'Fat Man', 'Trojan Horse', 'Spruce Goose', 'Spruce Goose', 58),
(2113, 'Who is the youngest person to recieve a Nobel Prize?', 'Lawrence Bragg', 'Werner Heisenberg', 'Yasser Arafat', 'Malala Yousafzai', 'Malala Yousafzai', 58),
(2114, 'De Eemhof, Port Zelande and Het Heijderbos are holiday villas owned by what company?', 'Yelloh Village', 'Keycamp', 'Villa Plus', 'Center Parcs', 'Center Parcs', 58),
(2115, 'Computer manufacturer Compaq was acquired for $25 billion dollars in 2002 by which company?', 'Toshiba', 'Asus', 'Dell', 'Hewlett-Packard', 'Hewlett-Packard', 58),
(2116, 'Which of these Marvel games was released on the Playstation 2?', 'Silver Surfer', 'Howard the Duck', 'Wolverine: Adamantium Rage', 'Spider-Man 2', 'Spider-Man 2', 58),
(2117, 'According to the 2014-2015 Australian Bureau of Statistics, what percentage of Australians were born overseas?', '13%', '20%', '7%', '28%', '28%', 58),
(2118, 'What was the destination of the missing flight MH370?', 'Kuala Lumpur', 'Singapore', 'Tokyo', 'Beijing', 'Beijing', 58),
(2119, 'What do the letters of the fast food chain KFC stand for?', 'Kentucky Fresh Cheese', 'Kibbled Freaky Cow', 'Kiwi Food Cut', 'Kentucky Fried Chicken', 'Kentucky Fried Chicken', 58),
(2120, 'What is a \"dakimakura\"?', 'A Chinese meal, essentially composed of fish', 'A yoga posture', 'A word used to describe two people who truly love each other', 'A body pillow', 'A body pillow', 58),
(2121, 'What name represents the letter \"M\" in the NATO phonetic alphabet?', 'Matthew', 'Mark', 'Max', 'Mike', 'Mike', 58),
(2122, 'What was the original name of the search engine \"Google\"?', 'CatMassage', 'SearchPro', 'Netscape Navigator', 'BackRub', 'BackRub', 59),
(2123, 'What are the three starter Pokemon available in Pokemon Black and White?', 'Snivy, Fennekin, Froakie', 'Chespin, Tepig, Froakie', 'Chespin, Fennekin, Oshawott', 'Snivy, Tepig, Oshawott', 'Snivy, Tepig, Oshawott', 59),
(2124, 'What is a \"dakimakura\"?', 'A Chinese meal, essentially composed of fish', 'A yoga posture', 'A word used to describe two people who truly love each other', 'A body pillow', 'A body pillow', 59),
(2125, 'Whose greyscale face is on the kappa emoticon on Twitch?', 'Justin DeSeno', 'John DeSeno', 'Jimmy DeSeno', 'Josh DeSeno', 'Josh DeSeno', 59),
(2126, 'Which church\'s interior in Vatican City was designed in 1503 by renaissance architects including Bramante, Michelangelo and Bernini?', 'Catania Cathedral', 'St. Mark’s Basilica', 'The Duomo of Florence', 'St. Peter\'s Basilica', 'St. Peter\'s Basilica', 59),
(2127, 'Which of the following  British Monarchs never appeared on a circulated pound sterling coin?', 'Victoria', 'George VI', 'Charles II', 'Edward VIII', 'Edward VIII', 59),
(2128, 'Which sign of the zodiac comes between Virgo and Scorpio?', 'Gemini', 'Taurus', 'Capricorn', 'Libra', 'Libra', 59),
(2129, 'How would one say goodbye in Spanish?', ' Hola', 'Au Revoir', 'Salir', 'Adiós', 'Adiós', 59),
(2130, 'What was the name given to Japanese military dictators who ruled the country through the 12th and 19th Century?', 'Ninja', 'Samurai', 'Shinobi', 'Shogun', 'Shogun', 59),
(2131, 'What zodiac sign is represented by a pair of scales?', 'Aries', 'Capricorn', 'Sagittarius', 'Libra', 'Libra', 59),
(2132, 'Which one of these paintings is not by Caspar David Friedrich?', 'The Sea of Ice', 'Wanderer above the Sea of Fog', 'The Monk by the Sea', 'The Black Sea', 'The Black Sea', 60),
(2133, 'Which of these are the name of a famous marker brand?', 'Dopix', 'Cofix', 'Marx', 'Copic', 'Copic', 60),
(2134, 'Which artist\'s style was to use small different colored dots to create a picture?', 'Paul Cézanne', 'Vincent Van Gogh', 'Henri Rousseau', 'Georges Seurat', 'Georges Seurat', 60),
(2135, 'Who designed the Chupa Chups logo?', 'Pablo Picasso', 'Andy Warhol', 'Vincent van Gogh', 'Salvador Dali', 'Salvador Dali', 60),
(2136, 'What French sculptor designed the Statue of Liberty? ', 'Jean-Léon Gérôme', 'Auguste Rodin', 'Henri Matisse', 'Frédéric Auguste Bartholdi', 'Frédéric Auguste Bartholdi', 60),
(2137, 'Which time signature is commonly known as “Cut Time?”', '4/4', '6/8', '3/4', '2/2', '2/2', 60),
(2138, 'Which of these is not an additional variation of the color purple?', 'Byzantium', 'Pomp and Power', 'Palatinate', 'Kobicha', 'Kobicha', 60),
(2139, 'Who painted the biblical fresco The Creation of Adam?', 'Leonardo da Vinci', 'Caravaggio', 'Rembrandt', 'Michelangelo', 'Michelangelo', 60),
(2140, 'Which artist’s studio was known as \'The Factory\'?', 'Roy Lichtenstein', 'David Hockney', 'Peter Blake', 'Andy Warhol', 'Andy Warhol', 60),
(2141, 'The painting \"The Starry Night\" by Vincent van Gogh was part of which art movement?', 'Romanticism', 'Neoclassical', 'Impressionism', 'Post-Impressionism', 'Post-Impressionism', 60);

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `quiz_id` int(11) NOT NULL,
  `decrp` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `nb_quest` int(11) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`quiz_id`, `decrp`, `titre`, `nb_quest`, `categorie`, `user_id`, `image_url`) VALUES
(57, 'ada', 'a', 10, 'Science: Mathematics', 6, '/gui/Rresources/quiz.png'),
(58, 'aze', 'qsd', 10, 'General Knowledge', 6, '/gui/Rresources/backa.png'),
(59, 'awaaa', 'aq', 10, 'General Knowledge', 6, '/gui/Rresources/426345709_271279715841474_1169622146843793990_n (1) copy.jpg'),
(60, 'aa', 'wa', 10, 'Art', 6, '/gui/Rresources/3974104.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `id_score` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL,
  `datesc` date DEFAULT NULL,
  `quiz_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `datenes` date NOT NULL,
  `mail` varchar(50) NOT NULL,
  `pswd` varchar(255) NOT NULL,
  `role` int(11) NOT NULL,
  `image` varchar(50) NOT NULL,
  `actif` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `nom`, `prenom`, `datenes`, `mail`, `pswd`, `role`, `image`, `actif`) VALUES
(4, 'karim', 'hhhhhhhhh', '2024-01-29', 'karim@esprit.com', 'N/dLDmBmSl3/XJQm7L5tFQ==', 1, 'user.png', 0),
(5, 'ghjkl', 'dfvgbhnjk,', '2024-01-29', 'hhhhhh@hhhhh.fr', 'N/dLDmBmSl3/XJQm7L5tFQ==', 0, 'user.png', 1),
(6, 'ahmed', 'ghoul', '2004-03-03', 'ahmed@gmail.com', 'D6ND69YD2J4sRXngf6+7fg==', 2, 'null', 0),
(7, 'ahmed', 'ghoul', '2003-03-01', 'ahmed1@gmail.com', 'D6ND69YD2J4sRXngf6+7fg==', 0, 'null', 0),
(8, 'ahmed', 'ghpuma', '2004-03-18', 'ahmed2@gmail.com', 'D6ND69YD2J4sRXngf6+7fg==', 1, 'null', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id_quest`),
  ADD KEY `fk_quiz_id` (`quiz_id`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`quiz_id`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`id_score`),
  ADD KEY `fk_quiz_idd` (`quiz_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id_quest` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2142;

--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `quiz_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
  MODIFY `id_score` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `fk_quiz_id` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`) ON DELETE CASCADE;

--
-- Constraints for table `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `fk_quiz_idd` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
