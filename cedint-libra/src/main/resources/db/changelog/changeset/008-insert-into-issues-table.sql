ALTER TABLE issues
    ALTER COLUMN id_type DROP NOT NULL;

INSERT INTO issues (
    id_pos,
    id_type,
    general_type,
    problem_title,
    priority,
    id_status,
    memo,
    id_user_created,
    id_assigned,
    description,
    assigned_date,
    creation_date,
    modify_date,
    solution
)
VALUES
    (
        1,
        NULL,
        'CONNECTION_ISSUE',
        'Terminal cannot connect to server',
        1,
        (SELECT id FROM statuses WHERE status = 'NEW'),
        NULL,
        (SELECT id FROM users WHERE login = 'andrei_djur'),
        NULL,
        'Connection timeout when starting terminal',
        NULL,
        CURRENT_DATE,
        CURRENT_DATE,
        NULL
    ),
    (
        1,
        NULL,
        'HARDWARE_FAILURE',
        'Printer not working',
        2,
        (SELECT id FROM statuses WHERE status = 'ASSIGNED'),
        NULL,
        (SELECT id FROM users WHERE login = 'camelia_gavriliuc'),
        (SELECT id FROM users WHERE login = 'dimka1900_PRO'),
        'Receipt printer does not respond',
        CURRENT_DATE,
        CURRENT_DATE,
        CURRENT_DATE,
        NULL
    ),
    (
        1,
        NULL,
        'SOFTWARE_ERROR',
        'Application crash on payment',
        1,
        (SELECT id FROM statuses WHERE status = 'IN_PROGRESS'),
        NULL,
        (SELECT id FROM users WHERE login = 'elena_23_master'),
        (SELECT id FROM users WHERE login = 'andrei_djur'),
        'App crashes when confirming payment',
        CURRENT_DATE,
        CURRENT_DATE,
        CURRENT_DATE,
        NULL
    );
