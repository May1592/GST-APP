CREATE TABLE GST_CONFIGURATION(
GST_CONFIG_ID UUID PRIMARY KEY NOT NULL,
GST_CONFIGURATION_NUMBER INTEGER NOT NULL DEFAULT nextval('SEQ_GST_CONFIG_NUMBER'),
GST_CONFIG_NAME VARCHAR NOT NULL,
GST_CONFIG_STATUS VARCHAR NOT NULL,
IS_MULTI_GST_CONFIG BOOLEAN DEFAULT FALSE,
CREATED_BY  VARCHAR,
CREATED_ON TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
UPDATED_BY VARCHAR,
UPDATED_ON TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE GST_MAPPING(
GST_MAPPING_ID UUID PRIMARY KEY NOT NULL,
GST_CONFIG_ID UUID REFERENCES CONFIGURATION(GST_CONFIG_ID),
GST_ID UUID,
GST_DEFINITION VARCHAR,
GST_STATUS VARCHAR,
MAPPED_BY VARCHAR,
MAPPED_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
APPROVED_BY VARCHAR,
APPROVED_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);