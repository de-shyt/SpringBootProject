-- Создание таблицы boards
CREATE TABLE boards (
    id BIGSERIAL PRIMARY KEY,
    owner_id BIGINT NOT NULL,
    description VARCHAR(100) NOT NULL
);

-- Создание junction-таблицы для связи many-to-many между boards и notes
CREATE TABLE board_notes (
    board_id BIGINT NOT NULL,
    note_id BIGINT NOT NULL,
    PRIMARY KEY (board_id, note_id),
    CONSTRAINT fk_board_notes_board FOREIGN KEY (board_id) REFERENCES boards(id),
    CONSTRAINT fk_board_notes_note FOREIGN KEY (note_id) REFERENCES notes(id)
);