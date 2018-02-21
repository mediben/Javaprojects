--
-- Database: `restAPI`
--


CREATE TABLE `organisation_department` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
);

-- --------------------------------------------------------

CREATE TABLE `organisation_department_employees` (
  `id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL
);

-- --------------------------------------------------------

CREATE TABLE `organisation_employee` (
  `id` int(11) NOT NULL,
  `created` datetime(6) NOT NULL,
  `title` varchar(100) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `status` varchar(100) NOT NULL,
  `salary` double NOT NULL,
  `alerts` int(11) NOT NULL,
  `address` longtext NOT NULL
);

-- --------------------------------------------------------

CREATE TABLE `organisation_store` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` longtext NOT NULL
);

-- --------------------------------------------------------

CREATE TABLE `organisation_store_departments` (
  `id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL
);


--
-- Indexes for tables
--
ALTER TABLE `organisation_department`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `organisation_department_employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `organisation_department__department_id_employee_i_6857fd6b_uniq` (`department_id`,`employee_id`),
  ADD KEY `organisation_department_employees_department_id_2b72b70a` (`department_id`),
  ADD KEY `organisation_department_employees_employee_id_bd82c709` (`employee_id`);


ALTER TABLE `organisation_employee`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `organisation_store`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `organisation_store_departments`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `organisation_store_depar_store_id_department_id_c29f568c_uniq` (`store_id`,`department_id`),
  ADD KEY `organisation_store_departments_store_id_67f5c963` (`store_id`),
  ADD KEY `organisation_store_departments_department_id_f744e3b4` (`department_id`);

--
-- AUTO_INCREMENT for tables
--

ALTER TABLE `organisation_department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `organisation_department_employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `organisation_employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `organisation_store`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `organisation_store_departments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
