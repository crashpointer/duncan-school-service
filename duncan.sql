PGDMP     "                     u            duncan    9.6.2    9.6.2 <    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           1262    16384    duncan    DATABASE     x   CREATE DATABASE duncan WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
    DROP DATABASE duncan;
             postgres    false            �           1262    16384    duncan    COMMENT     :   COMMENT ON DATABASE duncan IS 'Duncan''s school service';
                  postgres    false    2198                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12394    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16397    brands    TABLE     [   CREATE TABLE brands (
    id integer NOT NULL,
    name character varying(128) NOT NULL
);
    DROP TABLE public.brands;
       public         postgres    false    3            �           0    0    TABLE brands    COMMENT     B   COMMENT ON TABLE brands IS 'The table is kept brands of vehicle';
            public       postgres    false    187            �           0    0    brands    ACL     %   GRANT ALL ON TABLE brands TO PUBLIC;
            public       postgres    false    187            �            1259    16395    brands_id_seq    SEQUENCE     o   CREATE SEQUENCE brands_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.brands_id_seq;
       public       postgres    false    187    3            �           0    0    brands_id_seq    SEQUENCE OWNED BY     1   ALTER SEQUENCE brands_id_seq OWNED BY brands.id;
            public       postgres    false    186            �            1259    16407    models    TABLE     z   CREATE TABLE models (
    id integer NOT NULL,
    brand_id integer NOT NULL,
    name character varying(128) NOT NULL
);
    DROP TABLE public.models;
       public         postgres    false    3            �           0    0    models    ACL     %   GRANT ALL ON TABLE models TO PUBLIC;
            public       postgres    false    189            �            1259    16405    models_id_seq    SEQUENCE     o   CREATE SEQUENCE models_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.models_id_seq;
       public       postgres    false    189    3            �           0    0    models_id_seq    SEQUENCE OWNED BY     1   ALTER SEQUENCE models_id_seq OWNED BY models.id;
            public       postgres    false    188            �            1259    16434    roles    TABLE     Y   CREATE TABLE roles (
    id integer NOT NULL,
    name character varying(64) NOT NULL
);
    DROP TABLE public.roles;
       public         postgres    false    3            �           0    0    roles    ACL     $   GRANT ALL ON TABLE roles TO PUBLIC;
            public       postgres    false    193            �            1259    16432    roles_id_seq    SEQUENCE     n   CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.roles_id_seq;
       public       postgres    false    193    3            �           0    0    roles_id_seq    SEQUENCE OWNED BY     /   ALTER SEQUENCE roles_id_seq OWNED BY roles.id;
            public       postgres    false    192            �            1259    16440 
   user_roles    TABLE     X   CREATE TABLE user_roles (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);
    DROP TABLE public.user_roles;
       public         postgres    false    3            �           0    0 
   user_roles    ACL     )   GRANT ALL ON TABLE user_roles TO PUBLIC;
            public       postgres    false    194            �            1259    16420    users    TABLE     
  CREATE TABLE users (
    id integer NOT NULL,
    email character varying(256) NOT NULL,
    password character varying(256) NOT NULL,
    name character varying(64) NOT NULL,
    last_name character varying(64) NOT NULL,
    active boolean DEFAULT true NOT NULL
);
    DROP TABLE public.users;
       public         postgres    false    3            �           0    0    users    ACL     $   GRANT ALL ON TABLE users TO PUBLIC;
            public       postgres    false    191            �            1259    16418    users_id_seq    SEQUENCE     n   CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public       postgres    false    3    191            �           0    0    users_id_seq    SEQUENCE OWNED BY     /   ALTER SEQUENCE users_id_seq OWNED BY users.id;
            public       postgres    false    190            �            1259    16385    vehicles    TABLE     n  CREATE TABLE vehicles (
    nickname character varying(128) NOT NULL,
    plate character varying(8) NOT NULL,
    year smallint NOT NULL,
    active boolean DEFAULT true NOT NULL,
    type_of_vehicle smallint DEFAULT 1 NOT NULL,
    model_id integer NOT NULL,
    color character varying(8) DEFAULT '#FFFFFF'::character varying NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.vehicles;
       public         postgres    false    3            �           0    0    vehicles    ACL     '   GRANT ALL ON TABLE vehicles TO PUBLIC;
            public       postgres    false    185            �            1259    16474    vehicles_id_seq    SEQUENCE     q   CREATE SEQUENCE vehicles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.vehicles_id_seq;
       public       postgres    false    185    3            �           0    0    vehicles_id_seq    SEQUENCE OWNED BY     5   ALTER SEQUENCE vehicles_id_seq OWNED BY vehicles.id;
            public       postgres    false    195            �           2604    16400 	   brands id    DEFAULT     X   ALTER TABLE ONLY brands ALTER COLUMN id SET DEFAULT nextval('brands_id_seq'::regclass);
 8   ALTER TABLE public.brands ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    186    187    187            �           2604    16410 	   models id    DEFAULT     X   ALTER TABLE ONLY models ALTER COLUMN id SET DEFAULT nextval('models_id_seq'::regclass);
 8   ALTER TABLE public.models ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    188    189    189            �           2604    16437    roles id    DEFAULT     V   ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);
 7   ALTER TABLE public.roles ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    192    193    193            �           2604    16423    users id    DEFAULT     V   ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    190    191    191            �           2604    16476    vehicles id    DEFAULT     \   ALTER TABLE ONLY vehicles ALTER COLUMN id SET DEFAULT nextval('vehicles_id_seq'::regclass);
 :   ALTER TABLE public.vehicles ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    195    185            �          0    16397    brands 
   TABLE DATA               #   COPY brands (id, name) FROM stdin;
    public       postgres    false    187   ;       �           0    0    brands_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('brands_id_seq', 8, true);
            public       postgres    false    186            �          0    16407    models 
   TABLE DATA               -   COPY models (id, brand_id, name) FROM stdin;
    public       postgres    false    189   `;       �           0    0    models_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('models_id_seq', 7, true);
            public       postgres    false    188            �          0    16434    roles 
   TABLE DATA               "   COPY roles (id, name) FROM stdin;
    public       postgres    false    193   �;       �           0    0    roles_id_seq    SEQUENCE SET     3   SELECT pg_catalog.setval('roles_id_seq', 1, true);
            public       postgres    false    192            �          0    16440 
   user_roles 
   TABLE DATA               /   COPY user_roles (user_id, role_id) FROM stdin;
    public       postgres    false    194   �;       �          0    16420    users 
   TABLE DATA               F   COPY users (id, email, password, name, last_name, active) FROM stdin;
    public       postgres    false    191   �;       �           0    0    users_id_seq    SEQUENCE SET     3   SELECT pg_catalog.setval('users_id_seq', 2, true);
            public       postgres    false    190            �          0    16385    vehicles 
   TABLE DATA               `   COPY vehicles (nickname, plate, year, active, type_of_vehicle, model_id, color, id) FROM stdin;
    public       postgres    false    185   �<       �           0    0    vehicles_id_seq    SEQUENCE SET     6   SELECT pg_catalog.setval('vehicles_id_seq', 8, true);
            public       postgres    false    195                       2606    16402    brands idx_primary_brand_id 
   CONSTRAINT     R   ALTER TABLE ONLY brands
    ADD CONSTRAINT idx_primary_brand_id PRIMARY KEY (id);
 E   ALTER TABLE ONLY public.brands DROP CONSTRAINT idx_primary_brand_id;
       public         postgres    false    187    187                       2606    16412    models idx_primary_model_id 
   CONSTRAINT     R   ALTER TABLE ONLY models
    ADD CONSTRAINT idx_primary_model_id PRIMARY KEY (id);
 E   ALTER TABLE ONLY public.models DROP CONSTRAINT idx_primary_model_id;
       public         postgres    false    189    189                       2606    16439    roles idx_primary_role_id 
   CONSTRAINT     P   ALTER TABLE ONLY roles
    ADD CONSTRAINT idx_primary_role_id PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.roles DROP CONSTRAINT idx_primary_role_id;
       public         postgres    false    193    193                       2606    16429    users idx_primary_user_id 
   CONSTRAINT     P   ALTER TABLE ONLY users
    ADD CONSTRAINT idx_primary_user_id PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.users DROP CONSTRAINT idx_primary_user_id;
       public         postgres    false    191    191                       2606    16444 #   user_roles idx_primary_user_role_id 
   CONSTRAINT     h   ALTER TABLE ONLY user_roles
    ADD CONSTRAINT idx_primary_user_role_id PRIMARY KEY (user_id, role_id);
 M   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT idx_primary_user_role_id;
       public         postgres    false    194    194    194                       2606    16404    brands idx_unique_brand_name 
   CONSTRAINT     P   ALTER TABLE ONLY brands
    ADD CONSTRAINT idx_unique_brand_name UNIQUE (name);
 F   ALTER TABLE ONLY public.brands DROP CONSTRAINT idx_unique_brand_name;
       public         postgres    false    187    187            	           2606    16431    users idx_unique_user_email 
   CONSTRAINT     P   ALTER TABLE ONLY users
    ADD CONSTRAINT idx_unique_user_email UNIQUE (email);
 E   ALTER TABLE ONLY public.users DROP CONSTRAINT idx_unique_user_email;
       public         postgres    false    191    191            �           2606    16392 $   vehicles idx_unique_vehicle_nickname 
   CONSTRAINT     \   ALTER TABLE ONLY vehicles
    ADD CONSTRAINT idx_unique_vehicle_nickname UNIQUE (nickname);
 N   ALTER TABLE ONLY public.vehicles DROP CONSTRAINT idx_unique_vehicle_nickname;
       public         postgres    false    185    185            �           2606    16394 !   vehicles idx_unique_vehicle_plate 
   CONSTRAINT     V   ALTER TABLE ONLY vehicles
    ADD CONSTRAINT idx_unique_vehicle_plate UNIQUE (plate);
 K   ALTER TABLE ONLY public.vehicles DROP CONSTRAINT idx_unique_vehicle_plate;
       public         postgres    false    185    185                       2606    16413 !   models idx_foreign_model_brand_id    FK CONSTRAINT     �   ALTER TABLE ONLY models
    ADD CONSTRAINT idx_foreign_model_brand_id FOREIGN KEY (brand_id) REFERENCES brands(id) ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.models DROP CONSTRAINT idx_foreign_model_brand_id;
       public       postgres    false    2049    189    187                       2606    16450    user_roles idx_foreign_role_id    FK CONSTRAINT     �   ALTER TABLE ONLY user_roles
    ADD CONSTRAINT idx_foreign_role_id FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT idx_foreign_role_id;
       public       postgres    false    2059    194    193                       2606    16445    user_roles idx_foreign_user_id    FK CONSTRAINT     �   ALTER TABLE ONLY user_roles
    ADD CONSTRAINT idx_foreign_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT idx_foreign_user_id;
       public       postgres    false    191    2055    194                       2606    16462 %   vehicles idx_foreign_vehicle_model_id    FK CONSTRAINT     �   ALTER TABLE ONLY vehicles
    ADD CONSTRAINT idx_foreign_vehicle_model_id FOREIGN KEY (model_id) REFERENCES models(id) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.vehicles DROP CONSTRAINT idx_foreign_vehicle_model_id;
       public       postgres    false    2053    189    185            �   :   x�3�t�L,�2�t��2����KI�2��M-JNMI-VpJͫ���(�gr��qqq `X�      �   >   x�3�4�0�2Q�\ƜF�>�y��\&�Ɯ�>���9���\f���F\� �؀+F��� U�V      �      x�3�tt�������� �V      �      x�3�4����� f      �   �   x�e���   �3<�g��nei?��Y)l]�LA#���;v�{������I�O/��5��v�GftO=U�(��Z�c�B��O{#��M)y�S���zD�D#0WV�O�$�?�p����'�+�s�]�8��$:o��>�&�����萢M�ݟgTL�yy�� �_�>�      �   �   x�M�=�0E�_Q�.//���u)8�KZ�A����ۅ{8����5Cv\&����l��K����}1X����e�\����>�*N5�A � w�=��jt��lآ�����&=��<�����2�>��7|]��H�k�O�5��SJ} /     