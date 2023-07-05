INSERT INTO client (name)
VALUES
    ('William Brown'),
  	('Paul Brewer'),
  	('Phillip Howell'),
  	('Adam Watson'),
  	('Jack Reacher'),
  	('Lucas Anderson'),
    ('Isabella Johnson'),
    ('Noah Martinez'),
    ('Sophia Thompson'),
    ('Ethan Wright');

INSERT INTO planet (id, name)
VALUES
  ('ALC', 'Alpha Centauri'),
  ('PEG', 'Pegasus'),
  ('GJ 581c', 'Gliese'),
  ('Wolf 1061c', 'Wolf'),
  ('CAL', 'Callisto');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES
  ('2023-06-28T13:02:10Z', 2, 'ALC', 'GJ 581c'),
  ('2023-06-27T12:25:10Z', 1, 'GJ 581c', 'PEG'),
  ('2023-06-26T11:20:10Z', 3, 'PEG', 'Wolf 1061c'),
  ('2023-06-25T10:45:10Z', 4, 'CAL', 'GJ 581c'),
  ('2023-06-24T10:10:10Z', 2, 'ALC', 'CAL'),
  ('2023-06-23T09:15:10Z', 10, 'Wolf 1061c', 'GJ 581c'),
  ('2023-06-22T08:50:10Z', 8, 'GJ 581c', 'ALC'),
  ('2023-06-21T08:20:10Z', 7, 'CAL', 'ALC'),
  ('2023-06-20T07:30:10Z', 5, 'PEG', 'Wolf 1061c'),
  ('2023-06-19T06:10:10Z', 4, 'GJ 581c', 'PEG');