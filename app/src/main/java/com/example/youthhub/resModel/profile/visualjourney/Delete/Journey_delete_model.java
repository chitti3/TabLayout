package com.example.youthhub.resModel.profile.visualjourney.Delete;

public class Journey_delete_model {


        private Data data;

        private String message;

        private int status;

        public Data getData ()
        {
            return data;
        }

        public void setData (Data data)
        {
            this.data = data;
        }

        public String getMessage ()
        {
            return message;
        }

        public void setMessage (String message)
        {
            this.message = message;
        }

        public int getStatus ()
        {
            return status;
        }

        public void setStatus (int status)
        {
            this.status = status;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [data = "+data+", message = "+message+", status = "+status+"]";
        }



    public class Data
    {
        private String point_score_msg;

        public String getPoint_score_msg ()
        {
            return point_score_msg;
        }

        public void setPoint_score_msg (String point_score_msg)
        {
            this.point_score_msg = point_score_msg;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [point_score_msg = "+point_score_msg+"]";
        }
    }


}
