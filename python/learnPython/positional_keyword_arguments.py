def pos_key_args(message, default_arg="default", keyword_arg="keyword_arg"):
    print(message)
    print(default_arg)
    print(keyword_arg)
    pass


# pos_key_args('greet!!!')

if __name__ == "__main__":
    pos_key_args('Hi, Hello Dude!!')
    # pos_key_args() # This throws the type error because the positional/mandatory argument is missing
    pass
