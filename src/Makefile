NAME = avaj

$(NAME):
	@echo "." > sources.txt
	@find . -name "*.java" >> sources.txt
	@javac -sourcepath @sources.txt
	@echo "\033[1;32mCOMPILING SUCCESSFUL"
all: $(NAME)

clean:
	@rm -R lsibanda/aircraft/*.class lsibanda/tower/*.class lsibanda/provider/*.class lsibanda/exceptions/*.class lsibanda/main/*.class
	@rm sources.txt
	@rm simulation.txt
	@echo "\033[1;36mCLEAN SUCCESSFUL\033[0m"

fclean: clean
	@rm simulation.txt
re: fclean all