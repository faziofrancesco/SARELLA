    package model;

    public class Voto {
        private Integer idVoto;
        private Integer voto;

        public Voto(Integer voto) {
            this.voto = voto;
        }

        public Voto() {
        }

        public Integer getIdVoto() {
            return idVoto;
        }

        public void setIdVoto(Integer idVoto) {
            this.idVoto = idVoto;
        }

        public Integer getVoto() {
            return voto;
        }

        public void setVoto(Integer voto) {
            this.voto = voto;
        }
    }
