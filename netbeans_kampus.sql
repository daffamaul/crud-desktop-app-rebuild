--
-- Database: `netbeans_kampus`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nim` int DEFAULT NULL,
  `jurusan` varchar(255) DEFAULT NULL,
  `semester` int DEFAULT NULL
);

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nama`, `nim`, `jurusan`, `semester`) VALUES
(29, 'Daffa Maulana', 312210335, 'Teknik Informatika', 5),
(30, 'Raffi Maulana A', 312210337, 'Teknik Industri', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;
