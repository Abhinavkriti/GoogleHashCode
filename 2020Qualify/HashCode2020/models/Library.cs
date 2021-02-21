﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HashCode2020.models
{
    public class Library
    {
        public int id;

        public Library(int id, int capacity, int signup, HashSet<Book> booksL)
        {
            this.id = id;
            this.capacity = capacity;
            this.signup = signup;
            this.books = booksL;

            maxPotentialScore = books.Take(Math.Min((Global.Days - signup) * capacity, books.Count)).Select(b => b.score).Sum();            
        }

        internal void Dedup()
        {
            foreach(var book in books.OrderByDescending(b => b.score))
            {
                if (!Global.UsedBooks.Contains(book))
                {
                    Global.UsedBooks.Add(book);
                    scan.Add(book);
                }
            }

            maxPotentialScore = scan.Take(Math.Min((Global.Days - signup) * capacity, scan.Count)).Select(b => b.score).Sum();
        }

        public HashSet<Book> books;
        public int capacity;
        public int signup;
        public List<Book> scan = new List<Book>();
        public int maxPotentialScore = 0;
    }
}