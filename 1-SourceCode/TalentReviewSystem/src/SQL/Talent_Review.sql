-- Table: public."Employee_Info"

-- DROP TABLE public."Employee_Info";

CREATE TABLE public."Employee_Info"
(
  employee_id character varying(20) NOT NULL,
  start_level character varying(20) NOT NULL,
  last_promotion_date character varying(20) NOT NULL,
  gdc_start_date date NOT NULL,
  work_start_date date NOT NULL,
  department character varying(20) NOT NULL,
  CONSTRAINT employee_info_pkey PRIMARY KEY (employee_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Employee_Info"
  OWNER TO hr;

-- Table: public."Review_Period"

-- DROP TABLE public."Review_Period";

CREATE TABLE public."Review_Period"
(
  id integer NOT NULL DEFAULT nextval('"Review_Period_id_seq"'::regclass),
  review_period character(6) NOT NULL,
  CONSTRAINT "Review_Period_pkey" PRIMARY KEY (review_period)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Review_Period"
  OWNER TO hr;
-- Table: public."Supportive_Info"

-- DROP TABLE public."Supportive_Info";

CREATE TABLE public."Supportive_Info"
(
  employee_id character varying(20) NOT NULL,
  award integer NOT NULL,
  time_entry character varying NOT NULL,
  activity character varying NOT NULL,
  culture character varying,
  training character varying,
  recruting character varying,
  certification character varying,
  blog character varying,
  "CoE" character varying,
  review_period character(6) NOT NULL,
  CONSTRAINT "Supportive_Info_pkey" PRIMARY KEY (employee_id, review_period),
  CONSTRAINT "Supportive_Info_employee_id_fkey" FOREIGN KEY (employee_id)
      REFERENCES public."Employee_Info" (employee_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Supportive_Info_review_period_fkey" FOREIGN KEY (review_period)
      REFERENCES public."Review_Period" (review_period) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Supportive_Info"
  OWNER TO hr;
-- Table: public."Talent_Review_Score"

-- DROP TABLE public."Talent_Review_Score";

CREATE TABLE public."Talent_Review_Score"
(
  employee_id character varying(20) NOT NULL,
  achieving_results integer NOT NULL,
  org_impact integer NOT NULL,
  "learning _agility" integer NOT NULL,
  versatility integer NOT NULL,
  achieving_results_comment character varying NOT NULL,
  org_impact_comment character varying NOT NULL,
  "learning _agility_comment" character varying NOT NULL,
  versatility_comment character varying NOT NULL,
  review_period character(6) NOT NULL,
  CONSTRAINT "Talent_Review_Score_pkey" PRIMARY KEY (employee_id, review_period),
  CONSTRAINT "Talent_Review_Score_employee_id_fkey" FOREIGN KEY (employee_id)
      REFERENCES public."Employee_Info" (employee_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Talent_Review_Score_review_period_fkey" FOREIGN KEY (review_period)
      REFERENCES public."Review_Period" (review_period) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Talent_Review_Score"
  OWNER TO hr;

