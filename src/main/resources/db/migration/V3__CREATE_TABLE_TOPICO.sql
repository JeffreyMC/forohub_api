CREATE TABLE topico (
                        id SERIAL PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        mensaje TEXT NOT NULL,
                        fecha TIMESTAMP NOT NULL,
                        status VARCHAR(50) NOT NULL,
                        usuario_id BIGINT,
                        curso_id BIGINT,

                        CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE SET NULL,  -- Relación con 'usuario'
                        CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE SET NULL  -- Relación con 'curso'
);