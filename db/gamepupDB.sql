--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: accommodation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.accommodation (
    acc_id integer NOT NULL,
    acc_desc character varying(255) NOT NULL,
    acc_type character varying(255) NOT NULL
);


ALTER TABLE public.accommodation OWNER TO postgres;

--
-- Name: accommodation_acc_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.accommodation_acc_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.accommodation_acc_id_seq OWNER TO postgres;

--
-- Name: accommodation_acc_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.accommodation_acc_id_seq OWNED BY public.accommodation.acc_id;


--
-- Name: console; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.console (
    console_id integer NOT NULL,
    console_name character varying(255)
);


ALTER TABLE public.console OWNER TO postgres;

--
-- Name: console_console_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.console_console_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.console_console_id_seq OWNER TO postgres;

--
-- Name: console_console_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.console_console_id_seq OWNED BY public.console.console_id;


--
-- Name: developer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.developer (
    dev_id integer NOT NULL,
    dev_desc character varying(300),
    dev_name character varying(50) NOT NULL
);


ALTER TABLE public.developer OWNER TO postgres;

--
-- Name: developer_dev_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.developer_dev_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.developer_dev_id_seq OWNER TO postgres;

--
-- Name: developer_dev_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.developer_dev_id_seq OWNED BY public.developer.dev_id;


--
-- Name: game; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game (
    game_id integer NOT NULL,
    average_review_rating double precision,
    created_at timestamp(6) without time zone NOT NULL,
    game_desc character varying(300) NOT NULL,
    game_image character varying(200),
    game_name character varying(200) NOT NULL,
    is_coop boolean NOT NULL,
    is_online boolean NOT NULL,
    number_of_players integer NOT NULL,
    play_time integer NOT NULL,
    release_date timestamp(6) without time zone NOT NULL,
    updated_at timestamp(6) without time zone NOT NULL,
    mat_rating_id integer NOT NULL
);


ALTER TABLE public.game OWNER TO postgres;

--
-- Name: game_accommodation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_accommodation (
    acc_id integer NOT NULL,
    game_id integer NOT NULL
);


ALTER TABLE public.game_accommodation OWNER TO postgres;

--
-- Name: game_all_ratings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_all_ratings (
    game_game_id integer NOT NULL,
    all_ratings integer
);


ALTER TABLE public.game_all_ratings OWNER TO postgres;

--
-- Name: game_all_reviews; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_all_reviews (
    game_game_id integer NOT NULL,
    all_reviews integer
);


ALTER TABLE public.game_all_reviews OWNER TO postgres;

--
-- Name: game_console; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_console (
    game_price numeric(38,2),
    game_id integer NOT NULL,
    console_id integer NOT NULL
);


ALTER TABLE public.game_console OWNER TO postgres;

--
-- Name: game_developers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_developers (
    game_game_id integer NOT NULL,
    developers_dev_id integer NOT NULL
);


ALTER TABLE public.game_developers OWNER TO postgres;

--
-- Name: game_game_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.game_game_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.game_game_id_seq OWNER TO postgres;

--
-- Name: game_game_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.game_game_id_seq OWNED BY public.game.game_id;


--
-- Name: game_genre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_genre (
    genre_id integer NOT NULL,
    game_id integer NOT NULL
);


ALTER TABLE public.game_genre OWNER TO postgres;

--
-- Name: game_publishers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.game_publishers (
    game_game_id integer NOT NULL,
    publishers_pub_id integer NOT NULL
);


ALTER TABLE public.game_publishers OWNER TO postgres;

--
-- Name: genre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genre (
    genre_id integer NOT NULL,
    genre_desc character varying(255) NOT NULL,
    genre_type character varying(255) NOT NULL
);


ALTER TABLE public.genre OWNER TO postgres;

--
-- Name: genre_genre_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genre_genre_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.genre_genre_id_seq OWNER TO postgres;

--
-- Name: genre_genre_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.genre_genre_id_seq OWNED BY public.genre.genre_id;


--
-- Name: maturity_rating; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.maturity_rating (
    mat_rating_id integer NOT NULL,
    mat_rating_desc character varying(100) NOT NULL,
    mat_rating_letter character varying(4) NOT NULL,
    mat_rating_min_age integer NOT NULL
);


ALTER TABLE public.maturity_rating OWNER TO postgres;

--
-- Name: maturity_rating_mat_rating_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.maturity_rating_mat_rating_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.maturity_rating_mat_rating_id_seq OWNER TO postgres;

--
-- Name: maturity_rating_mat_rating_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.maturity_rating_mat_rating_id_seq OWNED BY public.maturity_rating.mat_rating_id;


--
-- Name: publisher; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.publisher (
    pub_id integer NOT NULL,
    pub_desc character varying(300),
    pub_name character varying(50)
);


ALTER TABLE public.publisher OWNER TO postgres;

--
-- Name: publisher_pub_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.publisher_pub_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.publisher_pub_id_seq OWNER TO postgres;

--
-- Name: publisher_pub_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.publisher_pub_id_seq OWNED BY public.publisher.pub_id;


--
-- Name: review; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.review (
    review_id integer NOT NULL,
    review_content character varying(255),
    review_date date,
    review_rating integer NOT NULL
);


ALTER TABLE public.review OWNER TO postgres;

--
-- Name: review_review_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.review_review_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.review_review_id_seq OWNER TO postgres;

--
-- Name: review_review_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.review_review_id_seq OWNED BY public.review.review_id;


--
-- Name: user_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_data (
    user_id integer NOT NULL,
    user_email character varying(255) NOT NULL,
    user_is_minor boolean NOT NULL,
    user_phone character varying(255),
    stored_hash bytea NOT NULL,
    stored_salt bytea NOT NULL,
    user_birth_date character varying(255) NOT NULL,
    user_fname character varying(255) NOT NULL,
    user_lname character varying(255) NOT NULL,
    user_name character varying(255)
);


ALTER TABLE public.user_data OWNER TO postgres;

--
-- Name: user_data_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_data_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_data_user_id_seq OWNER TO postgres;

--
-- Name: user_data_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_data_user_id_seq OWNED BY public.user_data.user_id;


--
-- Name: user_game; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_game (
    user_id integer NOT NULL,
    game_id integer NOT NULL,
    review_id integer
);


ALTER TABLE public.user_game OWNER TO postgres;

--
-- Name: accommodation acc_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accommodation ALTER COLUMN acc_id SET DEFAULT nextval('public.accommodation_acc_id_seq'::regclass);


--
-- Name: console console_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.console ALTER COLUMN console_id SET DEFAULT nextval('public.console_console_id_seq'::regclass);


--
-- Name: developer dev_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developer ALTER COLUMN dev_id SET DEFAULT nextval('public.developer_dev_id_seq'::regclass);


--
-- Name: game game_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game ALTER COLUMN game_id SET DEFAULT nextval('public.game_game_id_seq'::regclass);


--
-- Name: genre genre_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genre ALTER COLUMN genre_id SET DEFAULT nextval('public.genre_genre_id_seq'::regclass);


--
-- Name: maturity_rating mat_rating_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maturity_rating ALTER COLUMN mat_rating_id SET DEFAULT nextval('public.maturity_rating_mat_rating_id_seq'::regclass);


--
-- Name: publisher pub_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publisher ALTER COLUMN pub_id SET DEFAULT nextval('public.publisher_pub_id_seq'::regclass);


--
-- Name: review review_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review ALTER COLUMN review_id SET DEFAULT nextval('public.review_review_id_seq'::regclass);


--
-- Name: user_data user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_data ALTER COLUMN user_id SET DEFAULT nextval('public.user_data_user_id_seq'::regclass);


--
-- Data for Name: accommodation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.accommodation (acc_id, acc_desc, acc_type) FROM stdin;
1	Built-in text-to-speech feature narrating in-game text and menu options for visually impaired players.	Text-to-Speech Narration
2	Colorblind-friendly mode with distinct color palettes and iconography to enhance visibility for players with color vision deficiencies.	Colorblind-Friendly Mode
3	Audio descriptions for in-game visuals and actions, aiding visually impaired players in understanding the game environment.	Audio Descriptions
4	Customizable control schemes and button remapping options for players with mobility impairments or dexterity issues.	Custom Control Schemes
5	Subtitles and closed captioning for all in-game dialogue and audio cues, providing accessibility for players with hearing impairments.	Subtitles and Closed Captioning
6	Voice command recognition allowing players to navigate menus, control gameplay, and interact with in-game elements using voice commands.	Voice Command Recognition
7	Guided tutorials and hints system offering step-by-step instructions and guidance for players with cognitive disabilities or learning difficulties.	Guided Tutorials and Hints
8	Adaptive difficulty settings dynamically adjusting game challenges based on player performance to accommodate varying skill levels and disabilities.	Adaptive Difficulty Settings
9	One-handed mode with simplified controls and gameplay mechanics designed for players with limited hand mobility or amputations.	One-Handed Mode
10	Narrative-driven gameplay experiences with rich storytelling and minimal reliance on reflexes or fast-paced action, suitable for players with disabilities affecting reaction time.	Narrative-Driven Gameplay
\.


--
-- Data for Name: console; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.console (console_id, console_name) FROM stdin;
1	PlayStation 5
2	Xbox Series X
3	Nintendo Switch
4	PlayStation 4
5	Xbox One
6	Nintendo Wii U
7	Nintendo Wii
8	PlayStation 3
9	Xbox 360
\.


--
-- Data for Name: developer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.developer (dev_id, dev_desc, dev_name) FROM stdin;
1	A veteran developer known for their cutting-edge graphics and realistic simulations, delivering immersive experiences that blur the line between virtual and reality.	Quantum Dynamics
2	A rising star in the indie scene, specializing in atmospheric horror games with chilling narratives and psychological twists that keep players on the edge of their seats.	Midnight Games
3	A beloved developer with a knack for crafting charming platformers and colorful adventures, capturing the hearts of gamers of all ages with their whimsical worlds.	DreamWorks Interactive
4	A powerhouse studio behind blockbuster action titles and cinematic masterpieces, pushing the boundaries of visual storytelling and interactive entertainment.	Eclipse Entertainment
5	An innovative developer renowned for their groundbreaking gameplay mechanics and mind-bending puzzles, challenging players to think outside the box.	Enigma Studios
6	A boutique studio dedicated to crafting immersive VR experiences that transport players to fantastical realms and push the limits of virtual reality technology.	Virtuoso Games
7	A trailblazing developer known for their commitment to inclusivity and diversity, creating games that celebrate different cultures and perspectives.	Inclusive Interactive
8	A visionary developer pushing the boundaries of procedural generation and emergent gameplay, creating vast worlds filled with endless possibilities.	Nebula Games
9	A pioneering developer at the forefront of augmented reality gaming, blending the digital and physical worlds to create truly immersive gaming experiences.	Augmenta Studios
10	A passionate indie developer with a focus on narrative-driven adventures and emotional storytelling, exploring themes of love, loss, and redemption.	Heartfelt Games
\.


--
-- Data for Name: game; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.game (game_id, average_review_rating, created_at, game_desc, game_image, game_name, is_coop, is_online, number_of_players, play_time, release_date, updated_at, mat_rating_id) FROM stdin;
13	4.2	2023-02-28 15:45:00	Immerse yourself in the captivating world of cyberpunk espionage. Hack into secure networks, outsmart rival agents, and uncover the truth behind a global conspiracy in this thrilling stealth-action adventure.	\N	Cyber Sentinel	f	f	1	120	2023-02-15 00:00:00	2023-02-28 15:45:00	3
14	4.7	2022-09-05 10:15:00	Embark on a whimsical journey through a vibrant fantasy realm filled with colorful characters and charming landscapes. Solve puzzles, defeat enemies, and save the day in this enchanting platformer.	\N	Wonderland Adventures	f	f	1	60	2022-08-20 00:00:00	2022-09-05 10:15:00	1
15	3.5	2022-07-18 17:30:00	Take command of a squad of elite soldiers and lead them to victory in intense tactical battles. Plan your strategy, deploy your troops, and conquer the battlefield in this immersive turn-based strategy game.	\N	Tactical Strike: Operation Thunderbolt	t	t	20	45	2022-07-01 00:00:00	2022-07-18 17:30:00	3
16	4	2023-03-10 08:45:00	Explore the vast reaches of space in this epic sci-fi adventure. Build your own spaceship, recruit a crew of fearless adventurers, and chart a course for uncharted galaxies in search of fame and fortune.	\N	Starfarer Odyssey	t	t	4	180	2023-02-28 00:00:00	2023-03-10 08:45:00	2
17	4.9	2022-12-01 14:20:00	Embark on a magical journey through a whimsical world filled with wonder and danger. Solve puzzles, cast spells, and battle mythical creatures as you uncover the secrets of the lost kingdom.	\N	Mystic Quest	t	f	1	90	2022-11-20 00:00:00	2022-12-01 14:20:00	1
18	3.2	2022-10-30 11:00:00	Enter the arena and compete against players from around the world in fast-paced multiplayer battles. Master your favorite hero, team up with friends, and dominate the competition in this action-packed MOBA.	\N	Arena Clash	t	t	100	30	2022-10-15 00:00:00	2022-10-30 11:00:00	4
19	4.4	2023-01-20 16:00:00	Dive into a world of mystery and intrigue as you unravel the secrets of a forgotten civilization. Solve puzzles, uncover hidden treasures, and face ancient evils in this thrilling action-adventure.	\N	Lost Ruins	f	f	1	100	2023-01-10 00:00:00	2023-01-20 16:00:00	2
20	3.7	2022-08-15 13:45:00	Experience the thrill of high-speed racing in this adrenaline-fueled arcade-style game. Customize your car, compete in intense races, and become the champion of the asphalt in this action-packed racer.	\N	Nitro Rush	t	t	8	20	2022-07-30 00:00:00	2022-08-15 13:45:00	3
11	5	2023-01-15 09:00:00	Embark on an epic journey through a mythical world filled with monsters, magic, and mystery. Unravel the secrets of ancient civilizations and become the hero of legend in this immersive RPG adventure.	\N	Legends of Aetheria	t	f	1	80	2022-12-20 00:00:00	2024-04-23 12:23:52.189126	2
12	3.3333333333333335	2022-11-10 12:30:00	Experience heart-pounding action and intense firefights in this adrenaline-fueled first-person shooter. Join forces with friends in pulse-pounding cooperative missions or compete against players worldwide in thrilling online battles.	\N	Firestorm: Tactical Assault	t	t	50	40	2022-10-25 00:00:00	2024-04-23 12:25:22.150601	4
\.


--
-- Data for Name: game_accommodation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.game_accommodation (acc_id, game_id) FROM stdin;
1	11
2	11
3	11
2	12
5	12
2	13
6	13
1	14
7	14
5	15
9	15
8	16
10	16
1	17
2	17
3	18
5	18
2	19
9	19
4	20
\.


--
-- Data for Name: game_all_ratings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.game_all_ratings (game_game_id, all_ratings) FROM stdin;
11	3
\.


--
-- Data for Name: game_all_reviews; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.game_all_reviews (game_game_id, all_reviews) FROM stdin;
\.


--
-- Data for Name: game_console; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.game_console (game_price, game_id, console_id) FROM stdin;
59.99	11	1
59.99	11	2
49.99	11	3
39.99	12	2
39.99	12	5
59.99	12	6
49.99	13	3
49.99	13	6
49.99	13	7
39.99	14	5
39.99	14	8
59.99	14	9
49.99	15	4
49.99	15	7
39.99	15	8
59.99	16	1
59.99	16	2
49.99	16	3
49.99	17	3
49.99	17	6
49.99	17	7
39.99	18	1
39.99	18	2
29.99	18	3
59.99	19	2
49.99	19	5
49.99	19	8
39.99	20	1
39.99	20	2
29.99	20	3
\.


--
-- Data for Name: game_developers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.game_developers (game_game_id, developers_dev_id) FROM stdin;
11	1
12	2
13	3
14	4
15	5
16	6
17	7
18	8
19	9
20	10
\.


--
-- Data for Name: game_genre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.game_genre (genre_id, game_id) FROM stdin;
1	11
2	11
3	11
1	12
4	12
1	13
3	13
5	13
6	13
4	14
5	14
7	14
3	15
4	15
7	15
1	16
8	16
9	16
1	17
4	17
3	17
3	18
7	18
10	18
1	19
3	19
9	19
1	20
5	20
\.


--
-- Data for Name: game_publishers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.game_publishers (game_game_id, publishers_pub_id) FROM stdin;
11	1
12	2
13	3
14	4
15	5
16	1
17	2
18	3
19	4
20	5
\.


--
-- Data for Name: genre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genre (genre_id, genre_desc, genre_type) FROM stdin;
1	Action games emphasize physical challenges that require hand-eye coordination and motor skill to overcome. They center around the player, who is in control of most of the action.	Action
2	Fantasy games transport players to imaginative worlds filled with magic, mythical creatures, and epic quests. They offer an escape from reality and often involve heroism and adventure.	Fantasy
3	Role-playing games (RPGs) allow players to immerse themselves in rich narratives and assume the roles of characters within a fictional setting. Players make choices that impact the story and character development.	RPG
4	First-person shooters (FPS) put players in the perspective of a character wielding firearms to engage in combat against enemies. They emphasize fast-paced action and precision aiming.	FPS
5	Adventure games focus on exploration, puzzle-solving, and narrative-driven gameplay. Players navigate through interactive environments, uncovering secrets and solving challenges.	Adventure
6	Strategy games challenge players to use their tactical skills and resource management abilities to achieve specific objectives. They often involve planning, decision-making, and competition against opponents.	Strategy
7	Simulation games simulate real-world activities or systems, allowing players to experience scenarios they may not encounter in real life. They offer opportunities for creativity, experimentation, and learning.	Simulation
8	Sports games recreate real-life sports experiences, allowing players to compete in virtual versions of popular athletic competitions. They often feature realistic physics, rules, and player mechanics.	Sports
9	Puzzle games focus on solving challenges and puzzles, often requiring logic, spatial reasoning, and problem-solving skills. They offer engaging and mentally stimulating experiences.	Puzzle
10	Horror games immerse players in tense and terrifying scenarios, often involving supernatural or psychological elements. They aim to evoke fear and suspense through atmosphere and gameplay mechanics.	Horror
\.


--
-- Data for Name: maturity_rating; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.maturity_rating (mat_rating_id, mat_rating_desc, mat_rating_letter, mat_rating_min_age) FROM stdin;
1	Suitable for all ages. Cartoon or fantasy violence, mild language.	E	0
2	Parental guidance suggested. Moderate violence, mild language, minimal suggestive themes.	E10+	10
3	Not recommended for children under 13. Violence, suggestive themes, crude humor.	T	13
4	Content suitable for ages 17 and up. Intense violence, blood and gore, sexual content.	M	17
5	Restricted to adults. No one 17 and under. Prolonged scenes of graphic violence/sexual content.	AO	18
\.


--
-- Data for Name: publisher; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.publisher (pub_id, pub_desc, pub_name) FROM stdin;
1	One of the largest and most well-known publishers in the gaming industry, renowned for its diverse portfolio of critically acclaimed titles spanning various genres and platforms.	Electronic Arts
2	A leading publisher specializing in high-quality action-adventure and role-playing games, known for its immersive storytelling and innovative gameplay mechanics.	Ubisoft
3	A beloved publisher with a reputation for delivering exceptional platformers and family-friendly games that appeal to audiences of all ages.	Nintendo
4	A pioneering publisher known for its groundbreaking titles and commitment to pushing the boundaries of interactive entertainment.	Rockstar Games
5	A prominent publisher recognized for its innovative indie game lineup and support for emerging developers, fostering creativity and diversity in the gaming community.	Devolver Digital
\.


--
-- Data for Name: review; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.review (review_id, review_content, review_date, review_rating) FROM stdin;
1	I absolutely loved playing Cyber Sentinel! The gameplay mechanics are smooth, the storyline is engaging, and the graphics are stunning. Highly recommend it!	2024-04-19	4
2	Legends of Aetheria is an absolute masterpiece! The storyline is captivating, the graphics are stunning, and the combat system is exhilarating. Can't recommend it enough!	2024-04-19	5
3	Firestorm: Tactical Assault offers intense action-packed gameplay with realistic graphics and smooth controls. The multiplayer mode adds to the excitement!	2024-04-19	4
4	Cyber Sentinel provides a thrilling experience with its immersive world and engaging storyline. The hacking mechanics are especially enjoyable. Highly recommended for fans of the cyberpunk genre!	2024-04-19	4
5	Wonderland Adventures is a delightful adventure game with charming characters and creative puzzles. It's perfect for players of all ages!	2024-04-19	4
6	Tactical Strike: Operation Thunderbolt delivers action-packed gameplay with intense battles and strategic depth. The graphics are impressive, and the storyline is gripping!	2024-04-19	5
7	Starfarer Odyssey is a breathtaking sci-fi adventure with stunning visuals and immersive gameplay. The open-world exploration and space battles are simply amazing!	2024-04-19	5
8	Mystic Quest offers a captivating blend of action and adventure with its rich storyline and dynamic combat system. The fantasy world is beautifully crafted!	2024-04-19	4
9	Arena Clash is an engaging RPG with challenging quests and intense battles. The multiplayer mode adds depth to the gameplay experience!	2024-04-19	4
10	Lost Ruins is an intriguing survival game with immersive atmosphere and challenging gameplay. However, the pacing could be improved in certain areas.	2024-04-19	3
11	Nitro Rush offers fast-paced racing action with a variety of tracks and vehicles. While enjoyable, the game lacks some depth compared to other racing titles.	2024-04-19	3
12	Legends of Aetheria was disappointing. The gameplay felt repetitive and the graphics were lackluster.	2024-04-19	2
13	Firestorm: Tactical Assault is terrible. The controls are clunky and the graphics are outdated.	2024-04-19	1
14	Cyber Sentinel is awful.	2024-04-19	1
15		2024-04-19	2
16	Wonderland Adventures sux	2024-04-19	3
17	tactcle srike is bad	2024-04-19	2
18	starfarer odyssey is not good	2024-04-19	1
19	Mystic Quest rocks	2024-04-19	4
20	arena clash is bad	2024-04-19	2
21	lost ruins wasnt fun	2024-04-19	1
22	nitro rush is amazing	2024-04-19	5
23		2024-04-23	3
24	Pretty Darn GREAT!!!!	2024-04-23	5
25	Don't listen to the haters. This game is so much fun!	2024-04-23	5
\.


--
-- Data for Name: user_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_data (user_id, user_email, user_is_minor, user_phone, stored_hash, stored_salt, user_birth_date, user_fname, user_lname, user_name) FROM stdin;
1	john.doe@example.com	f	123-456-7890	\\x47fac4d4084a262fe2d8be48684bc8e8628a6a7a6bc154f7c4535465189d15ebf922aecdb619b4af7beed3d34a91c7e6a56049d77120009b09d232bea246ff0f	\\x597f822f4b76bc68c0501234835cb0cf7b4c640697480374fe9667cffa9cd7005c7f8ac15a164b19206ae094606c733fed6f4ff4c31b44f74a97db9e6c4890c973a9667bedf97fa1ce6724967fb3b28844ca9b3c7b1ee06f514cba9d1025f34d686881bd0e62d04e37e05e61b3c47c6150cb51387eb14d89759cd5b74772334b	1990-05-15	John	Doe	john_doe123
2	alice.smith@example.com	f	234-567-8901	\\x43c56b37444067731b981b5b035e9681cab82c304b3e7ed12d03d09329bf781a62af0a60eddfd51f91cee1a37105f165a520566131c01af83b6a890d6ccd6825	\\x366afbb008946f4836162302358db997fcd3cffb2e6dd0781d3e77eccaeec110d24ae6726ef03729a1a05eaaa3ac0ae7a49fc8735d049c2e49863662b3225b485fcb32b00b9eeed270d9c2342fb7f749f048860d564fd10d511bb0b7ce7ca9e98d10699323a3b5a852582246e821ca65719072c969ad55c9a35f6cac7c09acbc	1985-09-20	Alice	Smith	alice_smith456
3	michael.johnson@example.com	f	345-678-9012	\\xae5c55a173e8dcf88873c042e392f2fb35a75ca9cd2694bd16ed6c9d89f9dd3cb5d14664626feb18f30a2a11ec5dd32893f6a4483b29124ad2013a02da21a5fc	\\xcac2546c343631ba76b474a282becda2da0748d0e39efe2ef8de6df076b01b5a75218dac5ff42443a315597df269eeb132509a034a9bc36812436ecd8a99f9b2272592682e33358d39fe90fa45d3c8d9e11ec0e025fc8632e8cc8ac325a33755c1ec1c6aa725d62019c59377fbabe76af19fef5f57d0cb2ecb895b5003fb5cf0	1992-12-10	Michael	Johnson	michael_johnson789
4	emily.brown@example.com	f	456-789-0123	\\x611f3583c1e0c797411ef7811804079500dc536c8ec1f3a42c883f279c26cf4d1062ee95b5c192379c9799b467b971cb6c3d687e5b299604b7f62d00906b4fec	\\x393f2e438cc6c7dafc01304f699da5da11b4f7ca73b2d96f4fe094e2e2d841763f46bcd6d3b5924ecca223e14aa27d2c65bc51514e8951b9550ee67b737ce026681db17c7baebc560e0e6a8d64a868862df93ba3309a83b083ba2e0c1b01ddb0f529772f97a48114f22159aad46aa766527e33fe10990e400c7c605950d28937	1988-07-03	Emily	Brown	emily_brown123
5	david.martinez@example.com	f	567-890-1234	\\x3b56c39f5e3798da0155dfba5092558216661d91aeaa8195890f878dbbcce0ce51dc8714cd5a3ada8c1a0f2e7162479ae737d06334ded4228f6d733f90b1bb52	\\x5ec85a163a13e43c03d5f891730bfaf504f21f5d2decc5560e1f126ce9a63d21b800c3369d48232f1e244723e82dbaa329570b0b2b99e2e26ae48a52e30fc2a458c923a30d64d018a358ec057fbc8aae2ae11527944e69af7d0108bd095efa37d96ca9b8334062748773f6802662ec470c53ac326f465b22e3210f81302ade96	1995-04-25	David	Martinez	david_martinez456
6	chris.clark@example.com	f	789-012-3456	\\x9002ba23a1a40c05c78634dec103992a991768a21b87d728e3b27e19368f145acdcd6f40e25118fe5c1ae01b6e16c0425ef73c0b9161caed3e0b73de99b808b5	\\x122cfc4f999ee90b838feb5bce1fc043fa20620f6f0dff204bf0671e1ded301af49b1e1db462bf5c8d37d31858af2d76b3db55b75903193b546081780224b667f0cb5d89b18eeaa4e7f90aa6f99a2d7bbe0625fd8ec03ae2d1d24d25091152e8b3b7863c557332e9f3144905bc0c130158870843b95fcd6f56b831a3f7128bdc	1991-02-17	Chris	Clark	chris_clark123
7	jessica.white@example.com	f	890-123-4567	\\x707cbec02e761f40e42e0d8020b81bb63daffdc612983e6706a3a1d6fa5e153def7f308af40a7e0b42ce2eac6e17ede4095467e839de75123bac3147f690aa2c	\\xfa2b943135daec99fa60b1d306e8427902725468ddca50c1e9f5246b12082aea0be22fdbdbaa44c14e07c0a45e134d14ca29b4a83f3777e44b12b81960102a9091c4a7678ac3c489ca1b34e236029426d005b87dacdc477ef8d97167cdeca38bb6bcaed55c8c2a4e4461d0c837ced163816d0b0af18b7061847dffcbd2c6b796	1987-06-30	Jessica	White	jessica_white456
8	amanda.hall@example.com	f	012-345-6789	\\x5f594aae60f6c474d8d01a560b3e918da7ae72d0a12dea8f65545b31cc8ed220c4e0c9a7590c532cb8e6c5600064483a223b6ea453b1e00e7bb756ad02e8f7de	\\x18322e7bdaef3c62e7f7d5572395ce302ed2fb7dd29cfce346748a5bed136938e684c970f52c7e894fbb57a4a5f2611d1ffbfc80d127b075825273cb85edf4f68b77f74efa71674c042169ac9b890a380668e3974cc73860e674873a96590479e6a9c70163a5a75109dd40a187065ecc9174fbeff34d8da5dc6cbbe1f4921d47	1989-03-12	Amanda	Hall	amanda_hall123
\.


--
-- Data for Name: user_game; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_game (user_id, game_id, review_id) FROM stdin;
1	13	13
2	11	2
3	12	12
4	13	14
5	14	16
6	15	17
7	16	18
8	17	19
3	13	1
3	11	2
4	12	3
5	13	4
1	14	5
5	15	6
6	16	7
7	17	8
1	12	9
2	13	10
3	14	11
4	15	12
5	16	13
1	17	14
7	18	15
8	19	16
1	20	17
8	13	18
8	14	19
8	15	20
8	16	21
6	17	22
8	18	23
8	11	24
8	12	25
\.


--
-- Name: accommodation_acc_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.accommodation_acc_id_seq', 10, true);


--
-- Name: console_console_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.console_console_id_seq', 9, true);


--
-- Name: developer_dev_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.developer_dev_id_seq', 10, true);


--
-- Name: game_game_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.game_game_id_seq', 20, true);


--
-- Name: genre_genre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genre_genre_id_seq', 10, true);


--
-- Name: maturity_rating_mat_rating_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.maturity_rating_mat_rating_id_seq', 5, true);


--
-- Name: publisher_pub_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.publisher_pub_id_seq', 5, true);


--
-- Name: review_review_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.review_review_id_seq', 25, true);


--
-- Name: user_data_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_data_user_id_seq', 8, true);


--
-- Name: accommodation accommodation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accommodation
    ADD CONSTRAINT accommodation_pkey PRIMARY KEY (acc_id);


--
-- Name: console console_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.console
    ADD CONSTRAINT console_pkey PRIMARY KEY (console_id);


--
-- Name: developer developer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.developer
    ADD CONSTRAINT developer_pkey PRIMARY KEY (dev_id);


--
-- Name: game_accommodation game_accommodation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_accommodation
    ADD CONSTRAINT game_accommodation_pkey PRIMARY KEY (acc_id, game_id);


--
-- Name: game_console game_console_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_console
    ADD CONSTRAINT game_console_pkey PRIMARY KEY (console_id, game_id);


--
-- Name: game_developers game_developers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_developers
    ADD CONSTRAINT game_developers_pkey PRIMARY KEY (game_game_id, developers_dev_id);


--
-- Name: game_genre game_genre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_genre
    ADD CONSTRAINT game_genre_pkey PRIMARY KEY (game_id, genre_id);


--
-- Name: game game_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game
    ADD CONSTRAINT game_pkey PRIMARY KEY (game_id);


--
-- Name: game_publishers game_publishers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_publishers
    ADD CONSTRAINT game_publishers_pkey PRIMARY KEY (game_game_id, publishers_pub_id);


--
-- Name: genre genre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genre
    ADD CONSTRAINT genre_pkey PRIMARY KEY (genre_id);


--
-- Name: maturity_rating maturity_rating_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maturity_rating
    ADD CONSTRAINT maturity_rating_pkey PRIMARY KEY (mat_rating_id);


--
-- Name: publisher publisher_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.publisher
    ADD CONSTRAINT publisher_pkey PRIMARY KEY (pub_id);


--
-- Name: review review_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT review_pkey PRIMARY KEY (review_id);


--
-- Name: user_data user_data_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_data
    ADD CONSTRAINT user_data_pkey PRIMARY KEY (user_id);


--
-- Name: user_game user_game_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_game
    ADD CONSTRAINT user_game_pkey PRIMARY KEY (game_id, user_id);


--
-- Name: game_all_ratings fk1bvxs8ffwyfnwr8brt51pgys7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_all_ratings
    ADD CONSTRAINT fk1bvxs8ffwyfnwr8brt51pgys7 FOREIGN KEY (game_game_id) REFERENCES public.game(game_id);


--
-- Name: game_accommodation fk4hc63qh1nyh4glihdyxtj3rs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_accommodation
    ADD CONSTRAINT fk4hc63qh1nyh4glihdyxtj3rs FOREIGN KEY (acc_id) REFERENCES public.accommodation(acc_id);


--
-- Name: game fk5cccb54hi7opwy53h5jegxil3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game
    ADD CONSTRAINT fk5cccb54hi7opwy53h5jegxil3 FOREIGN KEY (mat_rating_id) REFERENCES public.maturity_rating(mat_rating_id);


--
-- Name: game_developers fk6a5678il3i7j5xtklpbmgiemd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_developers
    ADD CONSTRAINT fk6a5678il3i7j5xtklpbmgiemd FOREIGN KEY (developers_dev_id) REFERENCES public.developer(dev_id);


--
-- Name: game_accommodation fka9j7qyx8xr42uapjhxtli8kfw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_accommodation
    ADD CONSTRAINT fka9j7qyx8xr42uapjhxtli8kfw FOREIGN KEY (game_id) REFERENCES public.game(game_id);


--
-- Name: user_game fkb11fdcwlvhuemkjyk8w3bb2xw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_game
    ADD CONSTRAINT fkb11fdcwlvhuemkjyk8w3bb2xw FOREIGN KEY (user_id) REFERENCES public.user_data(user_id);


--
-- Name: game_genre fkfgiexxwmferkxqbwbjs989ea9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_genre
    ADD CONSTRAINT fkfgiexxwmferkxqbwbjs989ea9 FOREIGN KEY (genre_id) REFERENCES public.genre(genre_id);


--
-- Name: user_game fkg1pwaakahpjiu1io84bnnthys; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_game
    ADD CONSTRAINT fkg1pwaakahpjiu1io84bnnthys FOREIGN KEY (game_id) REFERENCES public.game(game_id);


--
-- Name: game_developers fki4nirk6x8p4gimxh9fkvpdx07; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_developers
    ADD CONSTRAINT fki4nirk6x8p4gimxh9fkvpdx07 FOREIGN KEY (game_game_id) REFERENCES public.game(game_id);


--
-- Name: game_publishers fkif97y4u5urdr4yjdhor1n6lv9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_publishers
    ADD CONSTRAINT fkif97y4u5urdr4yjdhor1n6lv9 FOREIGN KEY (game_game_id) REFERENCES public.game(game_id);


--
-- Name: game_publishers fkj1epyorbj0nnoofn2bhu32ic0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_publishers
    ADD CONSTRAINT fkj1epyorbj0nnoofn2bhu32ic0 FOREIGN KEY (publishers_pub_id) REFERENCES public.publisher(pub_id);


--
-- Name: game_genre fkj47t9lfhtj14lsg346bo3vujv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_genre
    ADD CONSTRAINT fkj47t9lfhtj14lsg346bo3vujv FOREIGN KEY (game_id) REFERENCES public.game(game_id);


--
-- Name: game_console fkkro7u8d787l8siv8f0kqysk7c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_console
    ADD CONSTRAINT fkkro7u8d787l8siv8f0kqysk7c FOREIGN KEY (game_id) REFERENCES public.game(game_id);


--
-- Name: game_all_reviews fkmi4tqkiymnop4p9nol1u3o4k0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_all_reviews
    ADD CONSTRAINT fkmi4tqkiymnop4p9nol1u3o4k0 FOREIGN KEY (game_game_id) REFERENCES public.game(game_id);


--
-- Name: game_console fknos8jku1mjnt16yvo6ybmnyt8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.game_console
    ADD CONSTRAINT fknos8jku1mjnt16yvo6ybmnyt8 FOREIGN KEY (console_id) REFERENCES public.console(console_id);


--
-- Name: user_game fkroos8bu65q91kd90ljbssrxd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_game
    ADD CONSTRAINT fkroos8bu65q91kd90ljbssrxd FOREIGN KEY (review_id) REFERENCES public.review(review_id);


--
-- PostgreSQL database dump complete
--

