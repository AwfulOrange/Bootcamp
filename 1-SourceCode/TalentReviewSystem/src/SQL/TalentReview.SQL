CREATE TABLE public."Employee_Info"
(
  employee_id character varying(20) NOT NULL,
  start_level character varying(20) NOT NULL,
  last_promotion_date character varying(20) NOT NULL,
  gdc_experience date NOT NULL,
  total_experience date NOT NULL,
  department character varying(20) NOT NULL,
  CONSTRAINT employee_info_pkey PRIMARY KEY (employee_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Employee_Info"
  OWNER TO postgres;
CREATE TABLE public."Score_Comm"
(
  employee_id character varying(20) NOT NULL,
  achieve_score integer NOT NULL,
  org_score integer NOT NULL,
  agility_score integer NOT NULL,
  versatility_score integer NOT NULL,
  achieve_comm character varying(20) NOT NULL,
  org_comm character varying(20) NOT NULL,
  agility_comm character varying(20) NOT NULL,
  versatility_comm character varying(20) NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Score_Comm"
  OWNER TO postgres;
CREATE TABLE public."Supportive_Info"
(
  emp_id character varying(20) NOT NULL,
  award integer NOT NULL,
  time_entry character varying NOT NULL,
  activity character varying NOT NULL,
  culture character varying,
  training character varying,
  recruting character varying,
  certification character varying,
  blog character varying,
  "CoE" character varying,
  CONSTRAINT supportive_info_pkey PRIMARY KEY (emp_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Supportive_Info"
  OWNER TO postgres;



